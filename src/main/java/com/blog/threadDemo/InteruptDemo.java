package com.blog.threadDemo;

import java.util.concurrent.TimeUnit;

/**
 * @author 一杯咖啡
 */
public class InteruptDemo {
    public static void main(String[] args) {
       /* Thread thread = new Thread(() -> {
            while (true) {
                System.out.println(Thread.interrupted());
            }
        });
        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.println("interupt");
        thread.interrupt();*/
       System.out.println("Main thread is interupted ? "+ Thread.interrupted());
       System.out.println("Main thread is interupted ? "+Thread.currentThread().isInterrupted());
       Thread.currentThread().interrupt();
       System.out.println("main is interupted ? "+Thread.currentThread().isInterrupted());
        try {
            TimeUnit.MINUTES.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("interupte still");
        }
    }
}
