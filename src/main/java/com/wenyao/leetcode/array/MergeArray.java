package com.wenyao.leetcode.array;

import java.util.Arrays;

/**
 * 合并排序数组
 */
public class MergeArray {
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 0, 0, 0};
        int[] b = new int[] {2, 5, 6};
        int m = 3, n = 3;
        merge(a, m, b, n);
        System.out.println(Arrays.toString(a));
    }

    public static void merge(int[] A, int m, int[] B, int n) {
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
