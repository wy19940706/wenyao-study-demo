package com.wenyao.leetcode.Freq5;

/**
 * @Description: 求x的n次方
 * @Author: wy
 * @CreateDate: 2019/3/13 23:32
 */
public class LeetCode50 {
    public static void main(String[] args) {
        System.out.println(pow(5, 2));
    }

    private static double pow(double x, int n) {
        if (n < 0) {
            return 1 / myPow(x, -n);
        } else {
            return myPow(x, n);
        }
    }

    private static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
