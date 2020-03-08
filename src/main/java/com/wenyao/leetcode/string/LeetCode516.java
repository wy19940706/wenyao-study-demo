package com.wenyao.leetcode.string;

/**
 * 最长回文子序列
 */
public class LeetCode516 {
    public static void main(String[] args) {

    }

    public int longestPalindromeSubseq(String str) {
        int length = str.length();
        int[][] dp = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }

}
