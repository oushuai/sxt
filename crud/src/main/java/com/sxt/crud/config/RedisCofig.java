package com.sxt.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author ouyangjie
 * @createTime 2019-12-15 11:36
 */
@Configuration
public class RedisCofig {
    @Bean("template")
    public RedisTemplate taskRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> configRedisTemplate = new RedisTemplate<>();
        configRedisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        configRedisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        configRedisTemplate.setKeySerializer(new StringRedisSerializer());
        configRedisTemplate.setHashKeySerializer(new StringRedisSerializer());
        configRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return configRedisTemplate;
    }


}
