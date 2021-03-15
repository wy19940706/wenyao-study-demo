package com.wenyao.leetcode.array;

/**
 * @author wenyao
 * @Description 搜索旋转排序数组 II
 * @Date 2021/3/16 上午12:27
 */
public class LeetCode81 {

    // 输入: nums = [2,5,6,0,0,1,2], target = 0
    // 输出: true
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }
            // 前半部分有序,注意此处用小于等于
            if (nums[start] < nums[mid]) {
                // target在前半部分
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target >= nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return false;
    }
}
