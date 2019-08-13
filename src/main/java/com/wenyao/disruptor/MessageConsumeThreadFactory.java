package com.wenyao.disruptor;

import java.util.concurrent.ThreadFactory;

/**
 * 消息消费线程工厂类
 */
public class MessageConsumeThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "disruptor-consumer-thread");
    }
}
