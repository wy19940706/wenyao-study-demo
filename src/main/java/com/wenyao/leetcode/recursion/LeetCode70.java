package com.wenyao.leetcode.recursion;

/**
 * @Description: 走阶梯
 * @Author: wy
 * @CreateDate: 2019/1/9 17:22
 */
public class LeetCode70 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(climbStairsOne(n));
        System.out.println(climbStairsTwo(n));
    }

    private static int climbStairsOne(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = n1 + n2;
            n1 = n2;
            n2 = tmp;
        }
        return n2;
    }

    private static int climbStairsTwo(int n) {
        if (n < 3) {
            return n;
        }
        return climbStairsTwo(n - 1) + climbStairsTwo(n - 2);
    }
}
