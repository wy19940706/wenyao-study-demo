package com.wenyao.leetcode.dp;

import java.util.Arrays;

/**
 * @author wenyao
 * @Description 打家劫舍II
 * @Date 2021/3/10 下午11:10
 */
public class LeetCode213 {

    // 时间复杂度 O(N)O(N) ： 两次遍历 nums 需要线性时间；
    // 空间复杂度 O(1)O(1) ： cur和 pre 使用常数大小的额外空间
    // dp[i] 代表前 i 个房子在满足条件下的能偷窃到的最高金额
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                    myRob(Arrays.copyOfRange(nums, 1, nums.length)));
        }

        private int myRob(int[] nums) {
            int pre = 0, cur = 0, tmp;
            for (int num : nums) {
                tmp = cur;
                cur = Math.max(pre + num, cur);
                pre = tmp;
            }
            return cur;
        }
    }

}
