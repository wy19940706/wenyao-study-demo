package com.wenyao.leetcode.dp;

/**
 * 兑换零钱（动态规划）
 */
public class ChangeCoins {
    public static void main(String[] args) {
        System.out.println(changeCoinsOne(41));
        System.out.println(changeCoinsTwo(41, new int[] {20, 25, 1, 5}));
    }

    /**
     * 自底向上递推
     * 
     * @param amount
     * @return
     */
    private static int changeCoinsThree(int amount) {
        return 0;
    }

    /**
     * 自顶向下记忆化搜索
     * 
     * @param amount
     * @return
     */
    private static int changeCoinsTwo(int amount, int[] faces) {
        if (amount < 1) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        for (int face : faces) {
            if (amount < face) {
                break;
            }
            dp[face] = 1;
        }
        return changeCoins2(amount, dp);
    }

    private static int changeCoins2(int n, int[] dp) {
        if (n < 1) {
            return Integer.MAX_VALUE;
        }
        if (dp[n] == 0) {
            int minOne = Math.min(changeCoinsTwo(n - 25, dp), changeCoinsTwo(n - 20, dp));
            int minTwo = Math.min(changeCoinsTwo(n - 5, dp), changeCoinsTwo(n - 1, dp));
            dp[n] = Math.min(minOne, minTwo) + 1;
        }
        return dp[n];
    }


    /**
     * 暴力递归
     * 
     * @param amount
     */
    public static int changeCoinsOne(int amount) {
        if (amount < 1) {
            return Integer.MAX_VALUE;
        }
        if (amount == 1 || amount == 5 || amount == 20 || amount == 25) {
            return 1;
        }
        int minOne = Math.min(changeCoinsOne(amount - 25), changeCoinsOne(amount - 20));
        int minTwo = Math.min(changeCoinsOne(amount - 5), changeCoinsOne(amount - 1));
        return Math.min(minOne, minTwo) + 1;
    }
}
