package com.wenyao.concurrentdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Think on 2019/1/28
 */
public class FutureAndCallableTest {

    private static final Logger logger = LoggerFactory.getLogger(FutureAndCallableTest.class);

    public static void main(String[] args) throws Exception {
        testSingleFutureAndCallable();
        testMultFutureAndCallable();
    }

    /**
     * 提交一组callable,谁先完成就先拿谁的结果
     */
    private static void testMultFutureAndCallable() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
        for (int i = 0; i < 10; i++) {
            final int num = i;
            completionService.submit(() -> {
                Thread.sleep(new Random().nextInt(3000));
                return "hello" + num;
            });
        }
        for (int i = 0; i < 10; i++) {
            Future<String> future = completionService.take();
            System.out.println(future.get());
        }
        executorService.shutdown();
    }

    /**
     * 测试只有一个线程一个任务的Future
     */
    private static void testSingleFutureAndCallable() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(3000);
            return "hello";
        });
        System.out.println("等待拿到结果");
        System.out.println(future.get());
        if (executorService.awaitTermination(3, TimeUnit.SECONDS)) {
            logger.info("work is running");
        }
        executorService.shutdown();
    }
}
