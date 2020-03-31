package com.wenyao.leetcode.num;

/**
 * 两数相除
 */
public class LeetCode29 {
    public static void main(String[] args) {

    }

    /**
     * @param dividend-被除数
     * @param divisor-除数
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) {
                return -dividend;
            }
            return Integer.MIN_VALUE;
        }
        long a = dividend;
        long b = divisor;
        int sign = 1;
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            sign = -1;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        long result = div(a, b);
        if (sign > 0) {
            return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
        }
        return (int) -result;
    }

    private static long div(long a, long b) {
        if (a < b) {
            return 0;
        }
        long count = 1;
        long tb = b;
        while ((tb + tb) <= a) {
            // 最小解翻倍
            count = count + count;
            // 测试值也翻倍
            tb = tb + tb;
        }
        return count + div(a - tb, b);
    }
}
