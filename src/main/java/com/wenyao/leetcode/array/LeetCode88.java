package com.wenyao.leetcode.array;

import java.util.Arrays;

/**
 * @Description: 给定2个排序好的整数数组nums1和nums2，把nums2合并到nums1中成为1个排序的数组(不去重)
 * @Author: wy
 * @CreateDate: 2019/1/13 22:24
 */
public class LeetCode88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {1, 2, 4};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len1 >= 0 && len2 >= 0) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }

    public static void mergeTwo(int[] A, int m, int[] B, int n) {
        int i = 0;
        int j = 0;
        int[] temp = new int[A.length];
        int index = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                temp[index++] = A[i++];
            } else {
                temp[index++] = B[j++];
            }
        }
        while (i < m) {
            temp[index++] = A[i++];
        }
        while (j < n) {
            temp[index++] = B[j++];
        }
        index = 0;
        for (int k = 0; k < A.length; k++) {
            A[k] = temp[index++];
        }
    }
}
