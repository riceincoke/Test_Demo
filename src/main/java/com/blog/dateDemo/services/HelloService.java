package com.blog.dateDemo.services;

import com.blog.dateDemo.interfaces.Hello;

public class HelloService implements Hello {
    @Override
    public void say(String name) {
        if (name == null || name.equals("")){
            throw new RuntimeException("NAME IS NULL");
        }
        System.out.println("Hello "+name);
    }
}
