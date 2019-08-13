package com.wenyao.disruptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.RingBuffer;

/**
 * 消息事件生产类
 */
public class MessageEventProducer {

    private static final Logger logger = LoggerFactory.getLogger(MessageEventProducer.class);

    private RingBuffer<MessageEvent> ringBuffer;

    public MessageEventProducer(RingBuffer<MessageEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * 将接收到的消息输出到ringBuffer
     *
     * @param message
     */
    public void onData(String message) {
        long sequence = ringBuffer.next();
        logger.info("申请的事件槽序号：[{}]", sequence);
        try {
            MessageEvent messageEvent = ringBuffer.get(sequence);
            messageEvent.setMessage(message);
            logger.info("生产者[{}] 生产消息:{}", Thread.currentThread().getName(), message);
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
