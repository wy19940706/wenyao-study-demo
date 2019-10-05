package com.wenyao.concurrentdemo.multithreadprint;

import cn.hutool.core.lang.Console;

/**
 * 两个线程交替打印奇数和偶数（0-100）
 */
public class SolutionOne implements Runnable {

    private static Object lock = new Object();
    private static int value = 0;

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        Thread threadA = new Thread(new SolutionOne(), "偶数线程");
        threadA.start();
        Thread threadB = new Thread(new SolutionOne(), "奇数线程");
        threadB.start();
        Console.log("这是主线程");
        System.exit(0);
    }

    @Override
    public void run() {
        while (value <= 100) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + ":" + value++);
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
