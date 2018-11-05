package com.blog.user.service;

import com.blog.BlogerApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Logger;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    private static Logger log = Logger.getLogger(UserServiceTest.class.getName());
    @Autowired
    private static ApplicationContext applicationContext;
    @Autowired private UserService service;

    @Before
    public void setUp() throws Exception {
        log.info("UserServiceTest 测试开始");
    }

    @After
    public void tearDown() throws Exception {
        log.info("UserServiceTest 测试结束");
    }

    @Test
    public void getOne() {
        System.out.println(service.getOne(1));
    }
}