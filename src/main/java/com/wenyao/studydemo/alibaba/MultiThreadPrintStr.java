package com.wenyao.studydemo.alibaba;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 多线程交替打印ali,每个线程打印完成之后sleep 100ms
 */
public class MultiThreadPrintStr {

    private static final Logger logger = LoggerFactory.getLogger(MultiThreadPrintStr.class);
    private static final String targetStr = "ali";
    private static final int threadNum = 3;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[threadNum];
        // 创建三个信号量，并把前两个先获取到用于后续释放
        final Semaphore[] syncObjects = new Semaphore[threadNum];
        for (int i = 0; i < threadNum; i++) {
            syncObjects[i] = new Semaphore(1);
            if (i != threadNum - 1) {
                syncObjects[i].acquire();
            }
        }
        for (int i = 0; i < threadNum; i++) {
            // 当前线程需要获取到的信号量
            final Semaphore currentSemaphore = i == 0 ? syncObjects[threadNum - 1] : syncObjects[i - 1];
            // 下一个线程需要去拿的信号量
            final Semaphore nextSemaphore = syncObjects[i];
            final int index = i;
            threads[i] = new Thread(() -> {
                try {
                    while (true) {
                        // 当前线程拿到信号量执行打印
                        currentSemaphore.acquire();
                        System.out.println("thread-" + index + ":" + targetStr.toCharArray()[index]);
                        Thread.sleep(100);
                        // 把下一个线程需要的信号量释放出去用于下一个线程获取
                        nextSemaphore.release();
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            });
            threads[i].start();
        }
    }
}
