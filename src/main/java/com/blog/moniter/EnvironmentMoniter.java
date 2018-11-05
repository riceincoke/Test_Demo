package com.blog.moniter;

import com.blog.BlogerApplication;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;
import javax.sql.CommonDataSource;
import javax.sql.DataSource;
import java.util.logging.Logger;

/**
 * desc:应用初始化打印各种配置
 * @Return: String
 **/
@Component
public class EnvironmentMoniter {
    static final Logger log = Logger.getLogger(BlogerApplication.class.getSimpleName());
    //事务管理器
    @Autowired private PlatformTransactionManager transactionManager;
    //数据源
    @Autowired private CommonDataSource dataSource;
    //redis操作
    @Autowired private RedisTemplate redisTemplate;

    @PostConstruct
    public void showTransactionManager(){
        log.info("事务管理器 : "+transactionManager.getClass().getName());
        log.info("数据源连接池 : "+dataSource.getClass().getName());
        log.info("redis操作 : "+redisTemplate.toString());
        log.info("redis连接工厂操作 : "+redisTemplate.getConnectionFactory().toString());

    }
}
