package com.wenyao.concurrentdemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Think on 2019/1/28
 */
public class FixedThreadPoolAndFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Future<Integer> integerFuture = executorService.submit(getResult(i));
            System.out.println(integerFuture.get());
        }
        executorService.shutdown();
    }

    private static Callable<Integer> getResult(int i) {
        return () -> i;
    }
}
