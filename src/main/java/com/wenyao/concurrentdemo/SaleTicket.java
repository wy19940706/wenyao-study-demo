package com.wenyao.concurrentdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 售票员卖票
 * @Author: wy
 * @CreateDate: 2019/5/16 23:13
 */
public class SaleTicket extends Thread {

    private static Integer count = 20;
    private static Object lock = new Object();

    public SaleTicket(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (count > 0) {
            synchronized (lock) {
                if (count > 0) {
                    System.out.println(getName() + "卖出了第" + count + "张票");
                    count--;
                } else {
                    System.out.println("票已经卖完了");
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.execute(new SaleTicket("售票员" + i));
        }
        executorService.shutdown();
    }
}
