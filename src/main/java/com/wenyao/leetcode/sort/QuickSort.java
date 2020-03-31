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
        // 每次把最开始的元素拿出来用来分隔数组
        int tmp = array[start];
        while (start < end) {
            // 从后开始往前扫描
            if (tmp <= array[end]) {
                end--;
            }
            // end处的值比tmp小了，则把end处的值放到start，此时end处就空了
            array[start] = array[end];
            // 此时再从前往后扫描
            if (start < end && tmp >= array[start]) {
                start++;
            }
            // start处的值比tmp大了，就放到end处去
            array[end] = array[start];
        }
        // 最终start处放上tmp
        array[start] = tmp;
        return start;
    }
}
