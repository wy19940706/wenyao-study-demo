package com.wenyao.studydemo;

/**
 * Created by Think on 2019/1/17
 */
public class DeadLockTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new DeadLock(true), "ThreadA");
        Thread thread2 = new Thread(new DeadLock(false), "ThreadB");
        thread1.start();
        thread2.start();
    }

    static class DeadLock implements Runnable {
        static Object lock1 = new Object();
        static Object lock2 = new Object();
        boolean lockFormer;

        public DeadLock(boolean lockFormer) {
            this.lockFormer = lockFormer;
        }

        @Override
        public void run() {
            if (lockFormer) {
                synchronized (lock1) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " get the lock1");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println(Thread.currentThread().getName() + " get the lock2");
                    }
                }
            } else {
                synchronized (lock2) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " get the lock2");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println(Thread.currentThread().getName() + " get the lock1");
                    }
                }
            }
        }
    }
}


