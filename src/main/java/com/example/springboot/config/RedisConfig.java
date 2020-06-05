package com.example.springboot.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.time.Duration;

import static com.example.springboot.constant.Constant.NUM_EIGHT;


/**
 * redis
 * A.缓存穿透：一般的缓存系统，都是按照key值去缓存查询，如果不存在对应的value，就应该去DB中查找 。这个时候，如果请求的并发量很大，就会对后端的DB系统造成很大的压力。这就叫做缓存穿透。关键词：缓存value为空；并发量很大去访问DB
 * 1.造成的原因（业务自身代码或数据出现问题；2.一些恶意攻击、爬虫造成大量空的命中，此时会对数据库造成很大压力。）
 * 2.解决方法
 * a.设置布隆过滤器，将所有可能存在的数据哈希到一个足够大的bitmap中，一个一定不存在的数据会被这个bitmap拦截掉，从避免了对底层存储系统的查询压力。
 * b.如果一个查询返回的数据为空，不管是数据不存在还是系统故障，我们仍然把这个结果进行缓存，但是它的过期时间会很短最长不超过5分钟
 * B.雪崩：：当缓存服务器重启或者大量缓存集中在某一个时间段失效，这样在失效的时候，大量数据会去直接访问DB，此时给DB很大的压力。
 * a.设置redis集群和DB集群的高可用，如果redis出现宕机情况，可以立即由别的机器顶替上来。这样可以防止一部分的风险。
 * b.使用互斥锁（在缓存失效后，通过加锁或者队列来控制读和写数据库的线程数量。比如：对某个key只允许一个线程查询数据和写缓存，其他线程等待。单机的话，可以使用synchronized或者lock来解决，如果是分布式环境，可以是用redis的setnx命令来解决。）
 * c.永远不过期（redis中设置永久不过期，这样就保证了，不会出现热点问题，也就是物理上不过期。）
 */
@Configuration
public class RedisConfig {

    /**
     * (最近在升级Springboot从1.5到2.0的时候，发现redis缓存的配置方式有所变化。)
     * RedisCacheManager的初始化方式有所变化，不能将RedisTemplate直接注入，而采用了新的创建方式。
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {

        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

        RedisSerializationContext.SerializationPair<Object> serializationPair = RedisSerializationContext
                .SerializationPair
                .fromSerializer(jackson2JsonRedisSerializer);

        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration
                .defaultCacheConfig()
                .serializeValuesWith(serializationPair)
                .entryTtl(Duration.ofSeconds(NUM_EIGHT));//设置缓存过期时间为8秒

        return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
    }


    /**
     * 接口限流相关
     */
    @Bean
    public RedisTemplate<String, Serializable> limitRedisTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Serializable> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
