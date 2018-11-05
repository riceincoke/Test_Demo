package com.blog.dateDemo.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Invocation {
    private Object[] params;
    private Method method;
    private Object target;

    public Invocation() {
    }

    public Invocation(Object[] params, Method method, Object target) {
        this.params = params;
        this.method = method;
        this.target = target;
    }

    /**
     * desc: 反射方法
     * @Return: Method.invoke()
     **/
    public Object proceed() throws InvocationTargetException,IllegalAccessException{
        return method.invoke(target, params);
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Invocation{" +
                "params=" + Arrays.toString(params) +
                ", method=" + method +
                ", target=" + target +
                '}';
    }
}
