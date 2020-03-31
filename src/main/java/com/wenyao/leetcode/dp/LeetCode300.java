package com.wenyao.leetcode.dp;

/**
 * 最长上升子序列(不一定连续)
 * 
 */
public class LeetCode300 {
    public static void main(String[] args) {
        int[] nums = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    // 输入: [10,9,2,5,3,7,101,18]
    // 输出: 4
    // 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(n)
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i]表示以nums[i]结尾的最长上升子序列的长度
        int[] dp = new int[nums.length];
        int max = dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
