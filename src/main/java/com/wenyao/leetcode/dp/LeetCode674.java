package com.wenyao.leetcode.dp;

import java.util.Arrays;

/**
 * 最长连续递增序列（字节跳动-使用滑动窗口）
 */
public class LeetCode674 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 1, 2};
        System.out.println(findLengthOfLCIS(nums));
    }

    // 时间复杂度：O(n) 空间复杂度：O(1)
    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int current = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                current = i;
            }
            result = Math.max(result, i - current + 1);
        }
        return result;
    }

    // dp做法 时间复杂度：O(n) 空间复杂度：O(n)
    public static int findLengthOfLCISOfDp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
