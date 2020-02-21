package com.wenyao.leetcode.sort;

import java.util.Arrays;

/**
 * @Description: 堆排序
 * @Author: wy
 * @CreateDate: 2019/3/19 1:00
 */
public class HeapSort {
    public static void main(String[] args) {
//        第一个元素不使用
        int[] array = new int[]{0, 8, 2, 3, 9, 5, 6};
        int length = array.length - 1;
//        调整为大顶堆
        for (int i = length / 2; i > 0; i--) {
            adjustHeap(array, i, length);
        }
        System.out.println(Arrays.toString(array));
//        与第一个元素交换，然后再调整为大顶堆
        for (int i = length; i > 1; i--) {
            swap(array, 1, i - 1);
            adjustHeap(array, 1, i - 1);
        }
        System.out.println(Arrays.toString(array));
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void adjustHeap(int[] array, int start, int end) {
        int temp = array[start];
        for (int i = start * 2; i <= end; i++) {
            if (i < end && array[i] < array[i + 1]) {
                i++;//右边的大
            }
            if (array[i] <= temp) {//已经满足大顶堆的条件
                break;
            }
            array[start] = array[i];
            start = i;
        }
        array[start] = temp;
    }
}
