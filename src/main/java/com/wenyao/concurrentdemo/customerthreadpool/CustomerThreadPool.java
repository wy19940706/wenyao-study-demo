package com.wenyao.concurrentdemo.customerthreadpool;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Sets;

/**
 * @Description: 自定义线程池
 * @Author: wy
 * @CreateDate: 2019/1/19 11:29
 */
public class CustomerThreadPool {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerThreadPool.class);
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 核心线程数
     */
    private volatile int miniSize;

    /**
     * 最大线程数
     */
    private volatile int maxSize;

    /**
     * 空闲线程存活时间
     */
    private long keepAliveTime;

    /**
     * 时间单位
     */
    private TimeUnit unit;

    /**
     * 任务队列
     */
    private BlockingQueue<Runnable> workQueue;

    /**
     * 存放线程池
     */
    private volatile Set<Worker> workerSet;

    /**
     * 是否关闭线程池标志
     */
    private AtomicBoolean isShutDown = new AtomicBoolean(false);

    /**
     * 提交到线程池的任务总数
     */
    private AtomicInteger totalTask = new AtomicInteger();

    /**
     * 线程池任务完全执行完的通知组件
     */
    private Object shutDownNotify = new Object();

    /**
     * 通知接口
     */
    private Notify notify;

    /**
     * 
     * @param miniSize
     * @param maxSize
     * @param keepAliveTime
     * @param unit
     * @param workQueue
     * @param notify
     */
    public CustomerThreadPool(int miniSize, int maxSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue, Notify notify) {
        this.miniSize = miniSize;
        this.maxSize = maxSize;
        this.keepAliveTime = keepAliveTime;
        this.unit = unit;
        this.workQueue = workQueue;
        this.notify = notify;
        workerSet = Sets.newConcurrentHashSet();
    }

    /**
     * 执行任务
     * 
     * @param runnable
     */
    public void execute(Runnable runnable) {
        if (Objects.isNull(runnable)) {
            throw new NullPointerException("runnable nullPointerException");
        }
        if (isShutDown.get()) {
            LOGGER.info("线程池已经关闭，请不要再提交任务");
            return;
        }

        // 提交的线程计数
        totalTask.incrementAndGet();

        if (workerSet.size() < miniSize) {
            addWorker(runnable);
            return;
        }

        boolean offer = workQueue.offer(runnable);
        if (!offer) {
            if (workerSet.size() < maxSize) {
                addWorker(runnable);
                return;
            } else {
                LOGGER.error("超过最大线程数");
                try {
                    workQueue.put(runnable);
                } catch (InterruptedException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }

    private void addWorker(Runnable runnable) {
        Worker worker = new Worker(runnable, true);
        worker.startTask();
        workerSet.add(worker);
    }


    private final class Worker extends Thread {

        private Runnable task;
        private Thread thread;
        private boolean isNewTask;

        public Worker(Runnable task, boolean isNewTask) {
            this.task = task;
            this.isNewTask = isNewTask;
            thread = this;
        }

        public void startTask() {
            thread.start();
        }

        public void close() {
            thread.interrupt();
        }

        @Override
        public void run() {
            Runnable task = null;

            if (isNewTask) {
                task = this.task;
            }

            try {
                while ((task != null) || ((task = getTask()) != null)) {
                    try {
                        task.run();
                    } finally {
                        // 任务执行完毕
                        task = null;
                        int number = totalTask.decrementAndGet();
                        LOGGER.info("number={}", number);
                        if (number == 0) {
                            synchronized (shutDownNotify) {
                                shutDownNotify.notify();
                            }
                        }
                    }
                }
            } finally {
                boolean remove = workerSet.remove(this);
                LOGGER.info("remove={},number={}", remove, workerSet.size());
                tryClose(true);
            }
        }
    }

    private Runnable getTask() {
        if (isShutDown.get() && totalTask.get() == 0) {
            return null;
        }
        lock.lock();
        try {
            Runnable task;
            if (workerSet.size() > miniSize) {
                task = workQueue.poll(keepAliveTime, unit);
            } else {
                task = workQueue.take();
            }
            if (task != null) {
                return task;
            }
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        } finally {
            lock.unlock();
        }
        return null;
    }

    private void tryClose(boolean isTry) {
        if (!isTry) {
            closeAllTask();
        } else {
            if (isShutDown.get() && totalTask.get() == 0) {
                closeAllTask();
            }
        }
    }

    private void closeAllTask() {
        for (Worker worker : workerSet) {
            LOGGER.info("work开始关闭");
            worker.close();
        }
    }

    /**
     * 获取工作线程数量
     * 
     * @return
     */
    public int getWorkCount() {
        return workerSet.size();
    }

    /**
     * 内部存放工作线程容器，并发安全
     * 
     * @param <T>
     */
    private final class ConcurrentHashSet<T> extends AbstractSet<T> {

        private ConcurrentHashMap<T, Object> map = new ConcurrentHashMap<>();
        private final Object present = new Object();
        private AtomicInteger count = new AtomicInteger();

        @Override
        public Iterator<T> iterator() {
            return map.keySet().iterator();
        }

        public boolean add(T t) {
            count.incrementAndGet();
            return map.put(t, present) == null;
        }

        @Override
        public int size() {
            return count.get();
        }

        @Override
        public boolean remove(Object o) {
            count.decrementAndGet();
            return map.remove(o) == present;
        }
    }
}
