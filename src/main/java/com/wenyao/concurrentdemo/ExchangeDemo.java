package com.wenyao.concurrentdemo;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Think on 2019/4/21
 */
public class ExchangeDemo {

    private static final Exchanger<String> exgr = new Exchanger<>();
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        executorService.execute(() -> {
            try {
                String A = "银行流水A";
                exgr.exchange(A);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                String B = "银行流水B";
                String A = exgr.exchange(B);
                System.out.println("A与B数据是否一致：" + A.equals(B) + ",A录入的是：" + A + ",B录入的是：" + B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
