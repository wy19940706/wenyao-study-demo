package com.wenyao.leetcode.array;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class LeetCode34 {

    public static void main(String[] args) {
        int[] nums = new int[] {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIndex = extremeInsertionIndex(nums, target, true);

        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return targetRange;
        }

        targetRange[0] = leftIndex;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }

    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }



    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int leftIdx = binarySearch(nums, target, true);
            int rightIdx = binarySearch(nums, target, false) - 1;
            if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
                return new int[] {leftIdx, rightIdx};
            }
            return new int[] {-1, -1};
        }

        public int binarySearch(int[] nums, int target, boolean lower) {
            int left = 0, right = nums.length - 1, ans = nums.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target || (lower && nums[mid] >= target)) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }

}
