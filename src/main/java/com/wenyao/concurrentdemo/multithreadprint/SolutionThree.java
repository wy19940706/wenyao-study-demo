package com.wenyao.concurrentdemo.multithreadprint;

public class SolutionThree implements Runnable {

    private static final Object LOCK = new Object();
    private static int current = 0;
    private int threadNo;
    private int threadCount;
    private String targetStr;

    public SolutionThree(int threadNo, int threadCount, String targetStr) {
        this.threadNo = threadNo;
        this.threadCount = threadCount;
        this.targetStr = targetStr;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (LOCK) {
                while (current % threadCount != threadNo) {
                    try {
                        LOCK.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("thread" + threadNo + ":" + targetStr.toCharArray()[threadNo]);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                current++;
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        int threadCount = 3;
        String targetStr = "ali";
        for (int i = 0; i < threadCount; i++) {
            new Thread(new SolutionThree(i, threadCount, targetStr)).start();
        }
    }
}
