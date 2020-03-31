package com.wenyao.leetcode.dp;

/**
 * 最大连续子序列和
 */
public class LeetCode53 {
    public static void main(String[] args) {
        int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArrayTwo(nums));
    }

    // 时间复杂度：O(n) 空间复杂度：O(1)-贪心
    public static int maxSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > 0) {
                array[i] += array[i - 1];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // 动态规划实现 时间复杂度O(n) 空间复杂度O(n)
    public static int maxSubArrayTwo(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] dp = new int[array.length];
        int max = dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + array[i];
            } else {
                dp[i] = array[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    // 可以优化空间复杂度为O(1) 时间复杂度：O(n)
    public static int maxSubArrayThree(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int dp = array[0];
        int max = dp;
        for (int i = 1; i < array.length; i++) {
            if (dp > 0) {
                dp = dp + array[i];
            } else {
                dp = array[i];
            }
            max = Math.max(dp, max);
        }
        return max;
    }
}
