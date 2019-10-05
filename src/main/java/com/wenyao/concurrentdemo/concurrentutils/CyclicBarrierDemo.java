package com.wenyao.concurrentdemo.concurrentutils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new CyclicBarrierTask(cyclicBarrier, i).start();
        }
    }

    private static class CyclicBarrierTask extends Thread {
        CyclicBarrier cyclicBarrier;
        Integer memberNum;

        public CyclicBarrierTask(CyclicBarrier cyclicBarrier, Integer memberNum) {
            this.cyclicBarrier = cyclicBarrier;
            this.memberNum = memberNum;
        }

        @Override
        public void run() {
            try {
                System.out.println("线程 " + memberNum + " 执行完成");
                Thread.sleep(3000L);
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程执行完成，继续后续操作");
        }
    }

}
