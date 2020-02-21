package com.wenyao.leetcode.sort;

/**
 * Created by Think on 2019/4/14
 */
public class SleepSort implements Runnable {

    private int num;

    public SleepSort(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        for (int num : nums) {
            new Thread(new SleepSort(num)).start();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.num);
            System.out.print(this.num + " ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
