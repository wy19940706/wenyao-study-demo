package com.wenyao.leetcode.array;

/**
 * 搜索旋转排序数组（字节跳动）
 */
public class LeetCode33 {

    public static void main(String[] args) {
        int[] nums = new int[] {4, 5, 6, 1, 2, 3};
        search(nums, 1);
    }

    // 4->5->6->1->2->3
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
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
        return -1;
    }
}
