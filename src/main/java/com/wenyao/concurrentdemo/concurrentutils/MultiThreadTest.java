package com.wenyao.concurrentdemo.concurrentutils;

import java.util.concurrent.CountDownLatch;

public class MultiThreadTest {

    private static volatile boolean isFinished = false;
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!isFinished) {
                System.out.println("isRunning");
                countDownLatch.countDown();
            }
            isFinished = false;
            System.out.println("finished:" + isFinished);
        }).start();

        countDownLatch.await();

        new Thread(() -> {
            isFinished = Boolean.TRUE;
            System.out.println("finished");
        }).start();
    }
}
