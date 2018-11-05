package com.blog.dateDemo.services;

import com.blog.dateDemo.interfaces.Incepter;
import com.blog.dateDemo.interfaces.Invocation;

public class MyIncepter implements Incepter {
    @Override
    public boolean Before() {
        System.out.println("before??????????");
        return true;
    }

    @Override
    public void After() {
        System.out.println("after?????????????");

    }

    @Override
    public Object around(Invocation invocation) throws Throwable {

        System.out.println("around before------------");
        Object obj = invocation.proceed();
        System.out.println("around after------------");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning-------------");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing-----------");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
