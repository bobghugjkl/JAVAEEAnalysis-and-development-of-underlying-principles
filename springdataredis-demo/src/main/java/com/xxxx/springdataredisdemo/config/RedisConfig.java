package com.xxxx.springdataredisdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String,Object>redisTemplate(LettuceConnectionFactory lettuceConnectionFactory){
        RedisTemplate<String, Object> objectObjectRedisTemplate = new RedisTemplate<>();
        objectObjectRedisTemplate.setKeySerializer(new StringRedisSerializer());
        objectObjectRedisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        objectObjectRedisTemplate.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
        objectObjectRedisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        objectObjectRedisTemplate.setConnectionFactory(lettuceConnectionFactory);
        return objectObjectRedisTemplate;
    }


    @Bean
    public RedisSentinelConfiguration redisSentinelConfiguration(){
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
                // 主节点名称
                .master("mymaster")
                // 主从服务器地址
                .sentinel("127.0.0.1", 26379)
                .sentinel("127.0.0.1", 26380)
                .sentinel("127.0.0.1", 26381);
        // 设置密码
        sentinelConfig.setPassword("123456");
        return sentinelConfig;
    }
}
