package com.wenyao.leetcode.dp;

import java.util.Arrays;

/**
 * @author wenyao
 * @Description 打家劫舍
 * @Date 2021/3/9 下午11:32
 */
public class LeetCode198 {

    // 递归+备忘录消除重叠子问题
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }
        int result = Math.max(
                // 不抢，去下家
                dp(nums, start + 1),
                // 抢，去下下家
                nums[start] + dp(nums, start + 2));
        memo[start] = result;
        return result;
    }

    // 自顶向下 时间：O(n) 空间：O（1）
    int rob2(int[] nums) {
        int n = nums.length;
        // 记录 dp[i+1] 和 dp[i+2]
        // dp[i] = x 表示：
        // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
        // base case: dp[n] = 0
        int dp1 = 0, dp2 = 0;
        // 记录 dp[i]
        int dpi = 0;
        for (int i = n - 1; i >= 0; i--) {
            dpi = Math.max(dp1, nums[i] + dp2);
            dp2 = dp1;
            dp1 = dpi;
        }
        return dpi;
    }
}
