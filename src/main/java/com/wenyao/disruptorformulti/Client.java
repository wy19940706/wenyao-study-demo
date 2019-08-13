package com.wenyao.disruptorformulti;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.WorkerPool;
import com.lmax.disruptor.dsl.ProducerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

/**
 * 客户端
 */
public class Client {

    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        // 创建一个ringBuffer
        RingBuffer<Order> ringBuffer =
                RingBuffer.create(ProducerType.MULTI, () -> new Order(), 1024 * 1024, new BlockingWaitStrategy());
        // 通过ringBuffer创建一个屏障
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
        // 创建10个消费者
        Consumer[] consumers = new Consumer[10];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Consumer("Consumer-" + i);
        }
        // 构建多消费者工作池
        WorkerPool<Order> workerPool =
                new WorkerPool<>(ringBuffer, sequenceBarrier, new EventExceptionHandler(), consumers);
        // 设置多个消费者的sequence序号，用于单独统计消费进度，并且设置到ringBuffer中
        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());
        // 启动workerPool
        workerPool.start(Executors.newFixedThreadPool(5));
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        for (int i = 0; i < 10; i++) {
            final Producer producer = new Producer(ringBuffer);
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
                for (int j = 0; j < 10; j++) {
                    producer.onData(UUID.randomUUID().toString());
                }
            }, "Producer-" + i).start();
        }
        logger.info("------------线程创建完毕，开始生产数据------------");
        Thread.sleep(5000);
        logger.info("任务总数：[{}]", consumers[2].getCount());
    }

    static class EventExceptionHandler implements ExceptionHandler<Order> {
        @Override
        public void handleEventException(Throwable ex, long sequence, Order event) {
            logger.error(ex.getMessage(), ex);
        }

        @Override
        public void handleOnStartException(Throwable ex) {
            logger.error(ex.getMessage(), ex);
        }

        @Override
        public void handleOnShutdownException(Throwable ex) {
            logger.error(ex.getMessage(), ex);
        }
    }
}
