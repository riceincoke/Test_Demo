package com.blog.dateDemo.services;


import com.blog.dateDemo.interfaces.Incepter;
import com.blog.dateDemo.interfaces.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements InvocationHandler {
    private Object target = null;
    private Incepter interceptor = null;

    public static Object getProxyBean(Object target,Incepter interceptor){
        ProxyBean proxyBean = new ProxyBean();
        proxyBean.target = target;
        proxyBean.interceptor = interceptor;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), proxyBean);
        return proxy;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(args,method,target);
        Object retonj = null;
        try {
            if (this.interceptor.Before()) {
                retonj = this.interceptor.around(invocation);
            } else {
                retonj = method.invoke(target, args);
            }
        }catch (Exception e){
            exceptionFlag = true;
        }

        this.interceptor.After();
        if (exceptionFlag){
            this.interceptor.afterThrowing();
        }else {
            this.interceptor.afterReturning();
            return retonj;
        }
        return null;
    }
}
