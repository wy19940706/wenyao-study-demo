package com.wenyao.leetcode.dp;

import java.util.Arrays;

/**
 * 最长连续递增子序列的个数（字节跳动）
 */
public class LeetCode673 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 4, 7};
        System.out.println(findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        int[] counter = new int[len];
        Arrays.fill(counter, 1);
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        counter[i] = counter[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        counter[i] += counter[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == maxLen) {
                result += counter[i];
            }
        }
        return result;
    }
}
