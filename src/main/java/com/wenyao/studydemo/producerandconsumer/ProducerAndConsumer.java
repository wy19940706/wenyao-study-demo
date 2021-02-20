package com.wenyao.studydemo.producerandconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer {

    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition producer = lock.newCondition();
    private static final Condition consumer = lock.newCondition();

    /**
     * 
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Producer());
            executorService.execute(new Consumer());
        }
        executorService.shutdown();
        while (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("work running");
        }
        System.out.println("work over");
    }

    private static class Producer implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                while (count.equals(FULL)) {
                    try {
                        producer.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                System.out.println(Thread.currentThread().getName() + "生产者生产,目前产品总计：" + count);
                consumer.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                while (count == 0) {
                    try {
                        consumer.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count--;
                System.out.println(Thread.currentThread().getName() + "消费者消费，目前还剩产品" + count);
                producer.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
