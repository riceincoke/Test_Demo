package com.blog.threadDemo;

import java.util.concurrent.TimeUnit;

public class Interupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.println("is interupted? "+thread.isInterrupted());
        thread.interrupt();
        System.out.println("is interupted? "+thread.isInterrupted());
    }
}
