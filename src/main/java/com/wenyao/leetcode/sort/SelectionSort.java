package com.wenyao.leetcode.sort;

import java.util.Arrays;

/**
 * @Description: 选择排序
 * @Author: wy
 * @CreateDate: 2019/3/19 22:04
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[] {5, 3, 21, 7, 4};
        System.out.println(Arrays.toString(selectSort(array)));
    }

    private static int[] selectSort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            // 每一轮找出最小的那个元素
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 把最小的元素放到最前面去
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
