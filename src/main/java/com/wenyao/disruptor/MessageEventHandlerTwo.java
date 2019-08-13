package com.wenyao.disruptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.EventHandler;

public class MessageEventHandlerTwo implements EventHandler<MessageEvent> {

    private static final Logger logger = LoggerFactory.getLogger(MessageEventHandlerTwo.class);

    @Override
    public void onEvent(MessageEvent event, long sequence, boolean endOfBatch) throws Exception {
        logger.info("线程[{}]后续处理消息：{}", Thread.currentThread().getName(), event.getMessage());
    }
}
