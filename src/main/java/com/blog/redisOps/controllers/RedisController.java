package com.blog.redisOps.controllers;

import com.blog.dateDemo.services.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.logging.Logger;
/**
 * <p>项目名称: ${} </p>
 * <p>文件名称: ${file_name} </p>
 * <p>描述: [类型描述]通过spring boot 提供的 redisTemplate 操作redis数据库 </p>
 **/
@RestController
@RequestMapping(value = "/redis")
public class RedisController {
    private static final Logger log = Logger.getLogger(RedisController.class.getName());
    @Autowired private RedisTemplate redisTemplate;
    /**
     * desc:测试redis 插入值
     * @Return:
     **/
    @GetMapping(value = "/insert")
    public String insert(){
        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                log.info("清空redis数据之前：：");
                log.info("test V: "+redisOperations.opsForValue().get("test"));
                log.info("test2 V: "+redisOperations.opsForValue().get("test2"));
                //清空redis数据
                redisTemplate.getConnectionFactory().getConnection().flushAll();
                log.info("清空redis数据之后：：");
                //开始事务监控
                // redisOperations.watch("test");
                //开启执行队列
                redisOperations.multi();
                // 断开连接
                // redisOperations.discard();

                redisOperations.opsForValue().set("test","");
                redisOperations.opsForValue().set("test2","123456");
                redisOperations.opsForHash().put("hashtable", "colum01", "columValue01");

                //绑定key 操作
                BoundValueOperations test = redisOperations.boundValueOps("test");

                test.set(test.get() != null?test.get():"this is a append string");
                log.info("test after appended size : "+test.size());
                log.info("test V: "+test.get());
                log.info("test2 V: "+redisOperations.opsForValue().get("test2"));
                //开始命令执行
                //log.info("未执行 exec 命令");
                //redisOperations.exec();
                log.info("执行 exec 命令");
                redisOperations.exec();

                //打印插入的值
                log.info("test value : "+test.get());
                log.info("test2 V: "+redisOperations.opsForValue().get("test2"));

                //hashtable 绑定操作
                BoundHashOperations<String,String,String> hst = redisOperations.boundHashOps("hashtable");
                log.info("hashtable size : "+hst.size());
                hst.put("colum02", "columnValue02");
                log.info("hashtable after put size : "+hst.size());

                //打印hashtable值
                Map<String,String> tableMap = hst.entries();
                Set<String> list = tableMap.keySet();
                System.out.println("HashTable Name : "+hst.getKey());
                for (String x:list){
                    System.out.println("K:"+x+" V:"+tableMap.get(x));
                }
                return null;
            }
        });
        return "yes";
    }
    /**
     * desc:redis 流水线测试
     * @Return:
     **/
    @GetMapping(value = "/pip")
    public String piped(){
        redisTemplate.getConnectionFactory().getConnection().flushAll();
        redisTemplate.executePipelined(new SessionCallback<Object>() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.opsForList().rightPush("pip", " ");
                BoundListOperations pipList = redisOperations.boundListOps("pip");
                for (int i = 0; i < 10000; i++) {
                    pipList.rightPush("test pip "+i);
                  // redisOperations.opsForValue().set("pip"+i,"this is a String"+i);
                }
                return null;
            }
        });
    return "yes pip";
    }
}
