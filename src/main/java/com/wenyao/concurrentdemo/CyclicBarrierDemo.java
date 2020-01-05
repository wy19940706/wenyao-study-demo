package com.wenyao.concurrentdemo;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Think on 2019/4/21
 */
public class CyclicBarrierDemo implements Runnable {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);
    private ExecutorService executor = Executors.newFixedThreadPool(4);
    private ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo();
        cyclicBarrierDemo.count();
    }

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                concurrentHashMap.put(Thread.currentThread().getName(), 1);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> item : concurrentHashMap.entrySet()) {
            result += item.getValue();
        }
        concurrentHashMap.put("result", result);
        System.out.println(result);
    }
}
