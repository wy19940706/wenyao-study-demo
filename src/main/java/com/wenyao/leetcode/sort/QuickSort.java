package com.wenyao.leetcode.sort;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 快速排序
 * @Author: wy
 * @CreateDate: 2019/3/14 17:39
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {5, 4, 6, 7, 1, 2, 3};
        quickSort(array, 0, 6);
        System.out.println(JSON.toJSONString(array));
    }

    private static void quickSort(int[] array, int start, int end) {
        if (array == null || array.length == 0) {
            return;
        }
        if (start < end) {
            int index = partition(array, start, end);
            quickSort(array, start, index - 1);
            quickSort(array, index + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            if (start < end && tmp <= array[end]) {
                end--;
            }
            array[start] = array[end];
            if (start < end && tmp >= array[start]) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = tmp;
        return start;
    }
}
