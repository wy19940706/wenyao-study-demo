package com.wenyao.concurrentdemo;

public class ThreadInterruptDemo {
    public static void main(String[] args) {
        Thread thread = new Thread("thread-interrupt");
        thread.start();
        thread.interrupt();
        System.out.println("第一次调用：" + thread.isInterrupted());
        System.out.println("第二次调用：" + thread.isInterrupted());

        Thread.currentThread().interrupt();
        System.out.println("第一次调用：" + Thread.interrupted());
        System.out.println("第二次调用：" + Thread.interrupted());

        thread.interrupt();
        System.out.println("第一次调用：" + Thread.interrupted());
        System.out.println("第二次调用：" + Thread.interrupted());
    }
}
