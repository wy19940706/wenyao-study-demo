package com.wenyao.concurrentdemo;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**

* @Description:    可重入自旋锁

* @Author:         wy

* @CreateDate:     2019/4/3 10:19

*/
public class ReentrantCycleLock {
    private AtomicReference<Thread> owner = new AtomicReference<>();
    private int state;

    public void lock() {
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            state++;
            return;
        }
        for (; ; ) {
            if (owner.compareAndSet(null, current)) {
                return;
            }
        }
    }

    public void unLock() {
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            if (state != 0) {
                state--;
            } else {
                owner.compareAndSet(current, null);
            }
        }
    }
}
