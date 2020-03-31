package com.wenyao.leetcode.dp;

/**
 *
 */
public class LeetCode523 {

    public static void main(String[] args) {
        int[] nums = new int[] {23, 2, 4, 6, 7};
        System.out.println(checkSubarraySum(nums, 6));
    }


    // 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
    // 示例 1:
    //
    // 输入: [23,2,4,6,7], k = 6
    // 输出: True
    // 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
    // 时间复杂度：O（n^3）空间复杂度：O(1)
    private static boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end < nums.length; end++) {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += nums[i];
                    if (sum == k || (k != 0 && sum % k == 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
