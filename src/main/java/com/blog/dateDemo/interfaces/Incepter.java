package com.blog.dateDemo.interfaces;

public interface Incepter {
    boolean Before();
    void After();
    Object around(Invocation invocation) throws Throwable;
    void afterReturning();
    void afterThrowing ();
    boolean useAround();
}
