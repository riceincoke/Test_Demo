package com.blog.admin.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

/**
 * desc: 打印所有方法调用
 * @Return: log
 **/
@Aspect
@Configuration
public class MyLog {
     Logger log = Logger.getLogger(MyLog.class.getSimpleName());
    /**
     * desc: 配置admin包下所有包下的类方法
     * @Return: void
     **/
    @Pointcut("execution(* com.blog.admin..*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint jp){
        log.info("调用方法 ："+jp.getSignature());
        /*System.out.println();
        System.out.println("调用方法 ："+jp.getSignature());*/
    }
}
