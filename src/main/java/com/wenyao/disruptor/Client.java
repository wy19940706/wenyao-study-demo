package com.wenyao.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

/**
 * 客户端
 */
public class Client {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        String message = "message-";
        int ringBufferSize = 8;
        Disruptor<MessageEvent> disruptor = new Disruptor<>(new MessageEventFactory(), ringBufferSize,
                new MessageConsumeThreadFactory(), ProducerType.SINGLE, new BlockingWaitStrategy());
        disruptor.handleEventsWith(new MessageEventHandler()).then(new MessageEventHandlerTwo());
        disruptor.setDefaultExceptionHandler(new MessageExceptionHandler());
        RingBuffer<MessageEvent> ringBuffer = disruptor.start();
        MessageEventProducer eventProducer = new MessageEventProducer(ringBuffer);
        for (int i = 0; i < 20; i++) {
            eventProducer.onData(message + i);
        }
        disruptor.shutdown();
    }
}
