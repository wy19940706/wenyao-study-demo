package com.wenyao.leetcode.sort;

import com.wenyao.leetcode.sort.tools.Integers;
import com.wenyao.leetcode.sort.tools.Times;

/**
 * @Description: 冒泡排序
 * @Author: wy
 * @CreateDate: 2019/3/19 0:44
 */
public class BubbleSort {
    public static void main(String[] args) {
        Integer[] arrayOne = Integers.tailAscOrder(1, 10000, 5);
        Integer[] arrayTwo = Integers.copy(arrayOne);
        Integer[] arrayThree = Integers.copy(arrayOne);
        Times.test("冒泡排序1", () -> bubbleSort(arrayOne));
        Times.test("冒泡排序2", () -> bubbleSortTwo(arrayTwo));
        Times.test("冒泡排序3", () -> bubbleSortThree(arrayThree));
    }

    private static void bubbleSort(Integer[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private static void bubbleSortOther(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                }
            }
        }

    }

    private static void bubbleSortTwo(Integer[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
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

    private static void bubbleSortThree(Integer[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int lastChangeIndex = 0;
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j + 1] < array[j]) {
                    isSorted = false;
                    int tmp = array[j + 1];
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
