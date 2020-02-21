package com.wenyao.leetcode.find;

/**
 * @Description: 统计一个数字在排序数组中出现的次数
 * @Author: wy
 * @CreateDate: 2019/4/15 23:01
 */
public class SwordToOffer52 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 2, 3, 4, 4, 4};
        System.out.println(getNumberOfK(array, 4));
    }

    private static int getNumberOfK(int[] nums, int k) {
        int first = binarySearch(nums, k);
        int last = binarySearch(nums, k + 1);
        return (first == nums.length || nums[first] != k) ? 0 : last - first;
    }

    private static int binarySearch(int[] nums, int k) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
