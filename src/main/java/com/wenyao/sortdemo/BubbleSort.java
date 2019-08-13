package com.wenyao.sortdemo;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 冒泡排序
 * @Author: wy
 * @CreateDate: 2019/3/19 0:44
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array1 = new int[]{3, 2, 1};
        bubbleSort(array1);
        System.out.println(JSON.toJSONString(array1));
        int[] array2 = new int[]{8, 6, 4, 3, 2, 1, 9};
        bubbleSortTwo(array2);
        System.out.println(JSON.toJSONString(array2));
        int[] array3 = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        bubbleSortThree(array3);
        System.out.println(JSON.toJSONString(array3));
    }

    private static void bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private static void bubbleSortTwo(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int temp;
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    private static void bubbleSortThree(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int tmp;
        int lastChangeIndex = 0;
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j + 1] < array[j]) {
                    isSorted = false;
                    tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    lastChangeIndex = j;
                }
            }
            sortBorder = lastChangeIndex;
            if (isSorted) {
                break;
            }
        }
    }
}
