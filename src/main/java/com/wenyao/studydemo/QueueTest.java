package com.wenyao.studydemo;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        final Queue<Integer> sharedQueue = new LinkedList();
        Thread producer = new Producer(sharedQueue);
        Thread consumer = new Consumer(sharedQueue);
        producer.start();
        consumer.start();
    }

}

class Producer extends Thread {
    private static final int MAX_QUEUE_SIZE = 5;
    private final Queue sharedQueue;

    public Producer(Queue sharedQueue) {
        super();
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (sharedQueue) {
                while (sharedQueue.size() >= MAX_QUEUE_SIZE) {
                    System.out.println("队列满了，等待消费");
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                sharedQueue.add(i);
                System.out.println("线程" + Thread.currentThread().getName() + "已经生产：数量" + sharedQueue.size());
                sharedQueue.notifyAll();//通知消费者可以消费了
            }
        }
    }
}

class Consumer extends Thread {
    private final Queue sharedQueue;

    public Consumer(Queue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQueue) {
                while (sharedQueue.size() == 0) {
                    System.out.println("队列已空，等待生产");
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int num = (Integer) sharedQueue.poll();
                System.out.println("线程" + Thread.currentThread().getName() + "已经消费：剩余数量" + sharedQueue.size());
                sharedQueue.notifyAll();//通知生产者可以生产了
            }
        }

    }

}