package com.wenyao.concurrentdemo.multithreadprint;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiThreadPrintNum {

    private static final Logger logger = LoggerFactory.getLogger(MultiThreadPrintNum.class);
    private static int result = 0;

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
            final Semaphore lastSemaphore = i == 0 ? syncObjects[threadNum - 1] : syncObjects[i - 1];
            final Semaphore currentSemaphore = syncObjects[i];
            final int index = i;
            threads[i] = new Thread(() -> {
                try {
                    while (true) {
                        lastSemaphore.acquire();
                        System.out.println("thread-" + index + ":" + result++);
                        if (result > 100) {
                            System.exit(0);
                        }
                        currentSemaphore.release();
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            });
            threads[i].start();
        }
    }
}
