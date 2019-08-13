package com.wenyao.studydemo.producerandconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private static final Logger logger = LoggerFactory.getLogger(ConditionTest.class);
    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition notFull = lock.newCondition();
    private static final Condition notEmpty = lock.newCondition();

    /**
     * 
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Producer(i));
            logger.info("开始启动消费者");
            executorService.execute(new Consumer(i));
        }
        executorService.shutdown();
        while (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("work running");
        }
        System.out.println("work over");
    }

    private static class Producer implements Runnable {

        private Integer index;

        public Producer(Integer index) {
            this.index = index;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                while (count == FULL) {
                    try {
                        notFull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                System.out.println(Thread.currentThread().getName() + "生产者生产,目前产品总计：" + count);
                notEmpty.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    private static class Consumer implements Runnable {

        private Integer index;

        public Consumer(Integer index) {
            this.index = index;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                while (count == 0) {
                    try {
                        notEmpty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count--;
                System.out.println(Thread.currentThread().getName() + "消费者消费，目前还剩产品" + count);
                notFull.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
