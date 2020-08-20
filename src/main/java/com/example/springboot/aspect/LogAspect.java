package com.example.springboot.aspect;

import com.alibaba.fastjson.JSON;
import com.example.springboot.annotation.Log;
import com.example.springboot.entities.SysLog;
import com.example.springboot.entities.SysUser;
import com.example.springboot.service.SysLogService;
import com.example.springboot.utils.DateUtil;
import com.google.common.collect.Lists;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

import static com.example.springboot.constant.Constant.NUM_ZERO;
import static com.example.springboot.constant.Constant.USER_AGENT;

/**
 * 系统日志
 */
@Aspect
@Component
@Slf4j
public final class LogAspect {


	@Autowired
	private SysLogService sysLogService;

	@Pointcut("@annotation(com.example.springboot.annotation.Log)")
	public void pointcut() {
	}

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		// 执行方法
		Object result = point.proceed();
		long time = System.currentTimeMillis() - beginTime;
		String logValue = saveLog(point, time);
		log.info("【" + logValue + "】【执行切面方法】耗时:{}毫秒", time);
		return result;
	}

	private String saveLog(ProceedingJoinPoint point, long time) {

		String logAnnotationValue = "";//返回Log注解上面的值

		MethodSignature signature = (MethodSignature) point.getSignature();

		// 获取方法
		Method method = signature.getMethod();

		SysLog log = new SysLog();

		Log logAnnotation = method.getAnnotation(Log.class);

		if (logAnnotation != null) {

			String value = logAnnotation.value();

			// 获取注解上的描述并设置
			log.setOperation(value);

			logAnnotationValue = value;
		}
		// 获取请求的类名
		String className = point.getTarget().getClass().getName();

		// 获取请求的方法名
		String methodName = signature.getName();

		// 设置method为类名+方法名
		log.setMethod(className + "." + methodName + "()");

		// 请求参数值
		Object[] args = point.getArgs();

		// 请求的方法参数名称
		LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
		String[] paramsNames = u.getParameterNames(method);
		if (args != null && paramsNames != null) {
			List<Object> list = Lists.newArrayList();
			for (int i = NUM_ZERO; i < args.length; i++) {
				if (!(args[i] instanceof HttpServletRequest) && !(args[i] instanceof MultipartFile && !(args[i] instanceof HttpServletResponse))) {
					list.add(args[i]);
				}
			}
			log.setParams(list.isEmpty() ? null : JSON.toJSONString(list));
		}

		// 获取request
		HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

		// 获取ip地址
		log.setIp(request.getRemoteAddr());

		//获取请求路径
		log.setRequestUrl(request.getRequestURI());

		// 设置操作时间
		log.setTime((int) time);

		// 获取用户信息
		SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();

		log.setUsername(user == null ? null : user.getChinaName());

		//TODO *******************获取浏览器和操作系统信息**********************************
		String userAgent = request.getHeader(USER_AGENT);

		UserAgent agent = UserAgent.parseUserAgentString(userAgent);

		Browser browser = agent.getBrowser();

		// 设置浏览器信息
		log.setBrowser(browser.getName());

		OperatingSystem os = agent.getOperatingSystem();

		// 设置操作系统信息
		log.setUserSystem(os.getName());

		log.setCreateTime(DateUtil.format());

		// 保存日志
		sysLogService.addSysLog(log);

		return logAnnotationValue;
	}
}
