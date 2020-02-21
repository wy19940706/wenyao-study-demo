package com.wenyao.leetcode.sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @Description: 归并排序
 * @Author: wy
 * @CreateDate: 2019/3/18 23:34
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 6, 1, 2, 8, 4, 2};
        System.out.println(JSON.toJSONString(mergeSort(array)));
    }

    private static int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int i = 0, index = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

}
