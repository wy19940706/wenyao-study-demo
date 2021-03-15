package com.wenyao.leetcode.window;

/**
 * @author wenyao
 * @Description 连续子数组的最大和
 * @Date 2021/3/11 上午12:08
 */
public class SwordToOffer42 {

    // 动态规划实现 时间复杂度O(n) 空间复杂度O(n)
    public static int maxSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        // dp[i] 代表以元素 nums[i]nums[i] 为结尾的连续子数组最大和
        int[] dp = new int[array.length];
        int max = dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + array[i];
            } else {
                dp[i] = array[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
