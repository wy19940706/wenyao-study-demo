package com.wenyao.concurrentdemo;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.LRUCache;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueExample {

    static class SynchronousProducer implements Runnable {

        protected BlockingQueue<String> blockingQueue;

        public SynchronousProducer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                String data = UUID.randomUUID().toString();
                System.out.println(Thread.currentThread().getName() + " put " + data);
                try {
                    blockingQueue.put(data);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class SynchronousConsumer implements Runnable {

        protected BlockingQueue<String> blockingQueue;

        public SynchronousConsumer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String data = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + " take " + data);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        final BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        SynchronousProducer synchronousProducer = new SynchronousProducer(blockingQueue);
        new Thread(synchronousProducer).start();

        SynchronousConsumer synchronousConsumerOne = new SynchronousConsumer(blockingQueue);
        new Thread(synchronousConsumerOne).start();

        SynchronousConsumer synchronousConsumerTwo = new SynchronousConsumer(blockingQueue);
        new Thread(synchronousConsumerTwo).start();

        LRUCache<String, Integer> objects = CacheUtil.newLRUCache(16, 2);
    }
}
