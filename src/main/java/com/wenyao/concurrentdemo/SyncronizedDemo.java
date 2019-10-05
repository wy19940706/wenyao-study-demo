package com.wenyao.concurrentdemo;

public class SyncronizedDemo {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        sync();
    }

    private static synchronized void sync() {
        synchronized (lock) {
            System.out.println("this is lock area");
        }
    }
}
