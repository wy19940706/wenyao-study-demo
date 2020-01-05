package com.wenyao.concurrentdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                threadLocal.set(Thread.currentThread().getName());
                System.out.println(threadLocal.get());
            });
        }
    }
}
