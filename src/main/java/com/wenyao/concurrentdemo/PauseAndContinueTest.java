package com.wenyao.concurrentdemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 线程启动-暂停-继续-停止demo
 */
public class PauseAndContinueTest {

    // private static final CountDownLatch countDownLatch = new CountDownLatch(1);
    private static final Object lock = new Object();
    private static AtomicBoolean isRunning = new AtomicBoolean(Boolean.FALSE);

    public static void main(String[] args) {
        new Thread(() -> {
            isRunning.set(Boolean.TRUE);
            // countDownLatch.countDown();
            while (true) {
                while (!isRunning.get()) {
                    synchronized (lock) {
                        System.out.println("暂停执行");
                        try {
                            lock.wait();
                            // 被唤醒之后睡眠5s再继续执行
                            TimeUnit.SECONDS.sleep(3L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("继续执行");
            }
        }).start();
        // 主线程sleep 3s对子线程进行暂停
        try {
            // countDownLatch.await();
            TimeUnit.SECONDS.sleep(3L);
            isRunning.set(Boolean.FALSE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 主线程让子线程继续执行
        synchronized (lock) {
            isRunning.set(Boolean.TRUE);
            lock.notify();
        }
    }


}
