package com.wenyao.concurrentdemo.concurrentutils;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    private static final Semaphore semaphore = new Semaphore(5);
    private static final Integer MEM_NUM = 8;

    public static void main(String[] args) {
        for (int i = 0; i < MEM_NUM; i++) {
            new SemaphoreTask(semaphore, i).start();
        }
    }

    private static class SemaphoreTask extends Thread {

        Semaphore semaphore;
        Integer memNum;

        public SemaphoreTask(Semaphore semaphore, Integer memNum) {
            this.semaphore = semaphore;
            this.memNum = memNum;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("线程" + memNum + "拿到许可，开始执行");
                Thread.sleep(3000L);
                System.out.println("线程" + memNum + "执行完毕，释放许可");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
