package com.wenyao.studydemo.producerandconsumer;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WaitNotifyTest {

    private static ExecutorService executorService;
    private static final Integer minSize = 0;
    private static final Integer maxSize = 10;
    private static Object lock = new Object();
    private static Integer count = 0;

    /**
     * 
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        initThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Producer());
            executorService.execute(new Consumer());
        }
        while (!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
            System.out.println("work running");
        }
        System.out.println("work over");
    }

    private static void initThreadPool() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("wenyao-thread-%d").build();
        executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10),
                namedThreadFactory, new ThreadPoolExecutor.DiscardPolicy());
    }

    private static class Producer implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (count.equals(maxSize)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                System.out.println(Thread.currentThread().getName() + "生产者生产，产品总计：" + count);
                lock.notify();
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (count.equals(minSize)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count--;
                System.out.println(Thread.currentThread().getName() + "消费者消费，剩余产品" + count);
                lock.notify();

            }
        }
    }

}
