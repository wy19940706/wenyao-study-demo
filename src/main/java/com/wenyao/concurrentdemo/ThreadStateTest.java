package com.wenyao.concurrentdemo;

import java.util.concurrent.TimeUnit;

/**
 * 线程状态测试
 */
public class ThreadStateTest {
    public static void main(String[] args) {
        new Thread(new Waiting(), "waiting-thread").start();
        new Thread(new TimedWaiting(), "timedwaiting-thread").start();
        new Thread(new Blocked(), "blocked-thread-1").start();
        new Thread(new Blocked(), "blocked-thread-2").start();
    }

    private static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class TimedWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
