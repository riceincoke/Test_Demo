package com.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Configuration
public class RedisConfig {
    private static final Logger log = Logger.getLogger(RedisConfig.class.getName());
    //redis操作类配置
    @Autowired private RedisTemplate redisTemplate;
    //修改 redisTemplate 的默认序列化方式
    @PostConstruct
    public void setRedisTemplateSeriableWay(){
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        RedisSerializer jdkSerializer = redisTemplate.getDefaultSerializer();
        log.info("redis默认序列化工具："+jdkSerializer +" , 已经修改为 StringSerializer");

        //设置key 的序列化方式
       // redisTemplate.setDefaultSerializer(stringSerializer);

        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        //设置value的序列化方式
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
    }
}
