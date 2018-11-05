package com.blog.dateDemo.services;

import com.blog.dateDemo.interfaces.Hello;

public class test {
    public static void main(String[] args){
        Hello hello = new HelloService();
        Hello proxy = (Hello) ProxyBean.getProxyBean(hello,new MyIncepter());
        proxy.say("he");
    }
}
