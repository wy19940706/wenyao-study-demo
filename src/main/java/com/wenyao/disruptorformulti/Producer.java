package com.wenyao.disruptorformulti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.RingBuffer;

/**
 * 生产者
 */
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    private final RingBuffer<Order> ringBuffer;

    public Producer(RingBuffer<Order> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * 生产数据
     *
     * @param orderId
     */
    public void onData(String orderId) {
        long sequence = ringBuffer.next();
        logger.info("生产者[{}]申请的事件槽序号：[{}]", Thread.currentThread().getName(), sequence);
        try {
            Order order = ringBuffer.get(sequence);
            order.setOrderId(orderId);
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
