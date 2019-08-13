package com.wenyao.disruptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.EventHandler;

/**
 * 消息事件处理类
 */
public class MessageEventHandler implements EventHandler<MessageEvent> {

    private static final Logger logger = LoggerFactory.getLogger(MessageEventHandler.class);

    @Override
    public void onEvent(MessageEvent messageEvent, long sequence, boolean endOfBatch) throws Exception {
        Thread.sleep(1000);
        logger.info("线程[{}] 消费消息：{}", Thread.currentThread().getName(), messageEvent.getMessage());
    }
}
