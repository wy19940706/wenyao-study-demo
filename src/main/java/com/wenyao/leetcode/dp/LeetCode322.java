package com.wenyao.leetcode.dp;

/**
 * 零钱兑换（动态规划）
 */
public class LeetCode322 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        // 从1开始，如果有面值去组合，则给dp[i]赋值，否则赋值Integer.MAX_VALUE
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (dp[i - coins[j]] != Integer.MAX_VALUE) {
                        min = Math.min(min, dp[i - coins[j]] + 1);
                    }
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
