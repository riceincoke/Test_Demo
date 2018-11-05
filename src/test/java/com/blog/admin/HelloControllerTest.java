package com.blog.admin;

import com.blog.admin.controller.AdminController;
import com.blog.admin.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest implements ApplicationContextAware {
    @Resource
    private MockMvc mockMvc;
    @Autowired
    private ApplicationContext ctx;
    @Test
    public void hello() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                    .andExpect(status().isOk()).andExpect(content().string("hello"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getBean(){
        System.out.println(ctx.getBeanDefinitionCount());
        Admin admin = (Admin) ctx.getBean("myadmin");
        System.out.println(admin.toString());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}