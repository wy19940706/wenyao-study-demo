package com.wenyao.leetcode.num;

/**
 * @Description: 判断一个数是否为丑数
 * @Author: wy
 * @CreateDate: 2019/4/15 16:00
 */
public class LeetCode999 {
    public static void main(String[] args) {
        System.out.println(isUgly(14));
    }

    private static boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        if (num == 1) {
            return true;
        }
        return false;
    }
}
