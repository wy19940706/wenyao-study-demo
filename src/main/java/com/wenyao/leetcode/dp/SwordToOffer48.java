package com.wenyao.leetcode.dp;

/**
 * @Description: 丑数（把只包含质因子2,3,5的数叫作丑数）,求第n个丑数，1为第一个丑数
 * @Author: wy
 * @CreateDate: 2019/4/2 23:17
 */
public class SwordToOffer48 {
    public static void main(String[] args) {

    }

    private static int getUglyNum(int n) {
        if (n <= 6) {
            return n;
        }
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[n];
        return 0;
    }
}
