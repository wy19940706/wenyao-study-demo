package com.wenyao.concurrentdemo.multithreadprint;

import java.util.concurrent.Semaphore;

/**
 * 使用信号量进行N个线程循环打印
 */
public class SolutionTwo {
    private static int result = 0;

    /**
     * 
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        int threadNum = 3;
        Thread[] threads = new Thread[threadNum];
        final Semaphore[] syncObjects = new Semaphore[threadNum];
        for (int i = 0; i < threadNum; i++) {
            syncObjects[i] = new Semaphore(1);
            if (i != threadNum - 1) {
                syncObjects[i].acquire();
            }
        }
        for (int i = 0; i < threadNum; i++) {
            final Semaphore lastSemphore = i == 0 ? syncObjects[threadNum - 1] : syncObjects[i - 1];
            final Semaphore curSemphore = syncObjects[i];
            final int index = i;
            threads[i] = new Thread(() -> {
                try {
                    while (true) {
                        lastSemphore.acquire();
                        System.out.println("thread-" + index + ":" + result++);
                        if (result > 100) {
                            System.exit(0);
                        }
                        curSemphore.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
    }
}
