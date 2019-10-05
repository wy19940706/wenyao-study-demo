package com.wenyao.concurrentdemo.concurrentutils;


import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    private static final CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                System.out.println("Thread-A is running");
                Thread.sleep(3000L);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-A").start();

        new Thread(() -> {
            try {
                System.out.println("Thread-B is running");
                Thread.sleep(3000L);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "Thread-B").start();
        countDownLatch.await();
        System.out.println("main thread run");
    }


}
