package com.example.springboot.aspect;

import com.example.springboot.annotation.Limit;
import com.example.springboot.annotation.LimitType;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Objects;

import static com.example.springboot.constant.Constant.*;

/**
 * 接口限流
 */
@Aspect
@Component
@Slf4j
public final class LimitAspect {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Pointcut("@annotation(com.example.springboot.annotation.Limit)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Limit limit = method.getAnnotation(Limit.class);
        LimitType limitType = limit.limitType();
        String name = limit.name();
        String key = null;
        int limitPeriod = limit.period();
        int limitCount = limit.count();
        switch (limitType) {
            case IP:
                key = getIpAddress();
                break;
            case CUSTOMER:
                key = limit.key();
                break;
            default:
                StringUtils.upperCase(method.getName());
        }
        ImmutableList<String> keys = ImmutableList.of(StringUtils.join(limit.prefix(), key));
        try {
            String luaScript = buildLuaScript();
            RedisScript<Number> redisScript = new DefaultRedisScript<>(luaScript, Number.class);
            Number count = redisTemplate.execute(redisScript, keys, limitCount, limitPeriod);
            log.info(REDIS_ACCESS_URL, count, name, key);
            if (count != null && count.intValue() <= limitCount) {
                return point.proceed();
            } else {
                throw new RuntimeException(REDIS_BLACK_LIST);
            }
        } catch (Throwable e) {
            if (e instanceof RuntimeException) {
                throw new RuntimeException(e.getLocalizedMessage());
            }
            throw new RuntimeException(SERVER_EXCEPTION);
        }


    }

    /**
     * 限流脚本
     * 调用的时候不超过阈值，则直接返回并执行计算器自加。
     *
     * @return lua脚本
     */
    public String buildLuaScript() {
        String lua = "local c" +
                "\nc = redis.call('get',KEYS[1])" +
                // 调用不超过最大值，则直接返回
                "\nif c and tonumber(c) > tonumber(ARGV[1]) then" +
                "\nreturn c;" +
                "\nend" +
                // 执行计算器自加
                "\nc = redis.call('incr',KEYS[1])" +
                "\nif tonumber(c) == 1 then" +
                // 从第一次调用开始限流，设置对应键值的过期
                "\nredis.call('expire',KEYS[1],ARGV[2])" +
                "\nend" +
                "\nreturn c;";
        return lua;
    }

    public String getIpAddress() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String ip = request.getHeader(X_FORWARDED_FOR);
        if (ip == null || ip.length() == NUM_ZERO || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(PROXY_CLIENT_IP);
        }
        if (ip == null || ip.length() == NUM_ZERO || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(WL_PROXY_CLIENT_IP);
        }
        if (ip == null || ip.length() == NUM_ZERO || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
