package com.wenyao.concurrentdemo.concurrentutils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
public class ReentrantLockDemo {

    private static Lock lock = new ReentrantLock(true);
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                executorService.execute(new Task());
            }
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            lock.lock();
            System.out.println("线程" + Thread.currentThread().getName() + "拿到锁了");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }
}
