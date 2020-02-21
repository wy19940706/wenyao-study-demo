package com.wenyao.leetcode.array;

import java.util.Arrays;

/**
 * @Description: 给定2个排序好的整数数组nums1和nums2，把nums2合并到nums1中成为1个排序的数组(不去重)
 * @Author: wy
 * @CreateDate: 2019/1/13 22:24
 */
public class LeetCode88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 4};
        int[] mergeNums = merge(nums1, nums1.length, nums2, nums2.length);
        System.out.println(Arrays.toString(mergeNums));
    }

    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int p1 = m - 1;
        int p2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (p2 < 0 || (p1 >= 0 && nums1[p1] > nums2[p2])) {
                result[i] = nums1[p1];
                p1--;
            } else {
                result[i] = nums2[p2];
                p2--;
            }
        }
        return result;
    }
}
