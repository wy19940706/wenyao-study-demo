package com.wenyao.concurrentdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Think on 2019/1/29
 */
public class CachedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int num = i;
            try {
                Thread.sleep(num * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(() -> System.out.println(num + "当前线程" + Thread.currentThread().getName()));
        }
        executorService.shutdown();
    }
}
