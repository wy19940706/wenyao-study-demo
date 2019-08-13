package com.wenyao.concurrentdemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Think on 2019/4/21
 */
public class CountdownLatchDemo implements Runnable {

    private static final CountDownLatch startSignal = new CountDownLatch(1);

    private static ExecutorService executorService = new ThreadPoolExecutor(10, 20, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

    @Override
    public void run() {
        try {
            startSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doWork();
    }

    private void doWork() {
        System.out.println("do work");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            executorService.execute(new CountdownLatchDemo());
        }
        startSignal.countDown();
        executorService.shutdown();
    }
}
