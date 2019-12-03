package com.wenyao.studydemo.producerandconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTestTwo {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        ConditionTestTwo conditionTestTwo = new ConditionTestTwo();
        new Thread(conditionTestTwo::await, "Thread-1").start();
        Thread.sleep(3000);
        new Thread(conditionTestTwo::signal, "Thread-2").start();
    }

    private void await() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "开始阻塞等待");
            condition.await();
            System.out.println(Thread.currentThread().getName() + "结束阻塞等待");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void signal() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "开始通知");
        condition.signal();
        lock.unlock();
    }
}
