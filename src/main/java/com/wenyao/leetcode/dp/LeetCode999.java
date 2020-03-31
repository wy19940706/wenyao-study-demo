package com.wenyao.leetcode.dp;

/**
 * 走格子
 */
public class LeetCode999 {
    public static void main(String[] args) {

    }

    private static int getWay(int[][] array, int m, int n) {
        int[][] dp = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < array[0].length; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (i == m && j == n) {
                    return dp[i][j];
                }
            }
        }
        return -1;
    }
}
