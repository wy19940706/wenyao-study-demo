package com.wenyao.concurrentdemo.concurrentsimulate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountDownLatchUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountDownLatchUtil.class);

    private CountDownLatch start;
    private CountDownLatch end;
    private int pollSize = 10;

    public CountDownLatchUtil() {
        this(10);
    }

    public CountDownLatchUtil(int pollSize) {
        this.pollSize = pollSize;
        start = new CountDownLatch(1);
        end = new CountDownLatch(pollSize);
    }

    public void latch(MyFunctionalInterface functionalInterface) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(pollSize);
        for (int i = 0; i < pollSize; i++) {
            Runnable runnable = () -> {
                try {
                    start.await();
                    functionalInterface.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    end.countDown();
                }
            };
            executorService.submit(runnable);
        }
        start.countDown();
        end.await();
        while (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            LOGGER.info("task is working");
        }
        executorService.shutdown();
    }
}
