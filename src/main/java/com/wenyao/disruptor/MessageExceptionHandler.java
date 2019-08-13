package com.wenyao.disruptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.ExceptionHandler;

public class MessageExceptionHandler implements ExceptionHandler<MessageEvent> {

    private static final Logger logger = LoggerFactory.getLogger(MessageExceptionHandler.class);

    @Override
    public void handleEventException(Throwable throwable, long sequence, MessageEvent messageEvent) {
        logger.error(throwable.getMessage(), throwable);
    }

    @Override
    public void handleOnStartException(Throwable throwable) {
        logger.error(throwable.getMessage(), throwable);
    }

    @Override
    public void handleOnShutdownException(Throwable throwable) {
        logger.error(throwable.getMessage(), throwable);
    }
}
