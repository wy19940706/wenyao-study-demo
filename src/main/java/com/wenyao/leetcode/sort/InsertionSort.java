package com.wenyao.leetcode.sort;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 插入排序
 * @Author: wy
 * @CreateDate: 2019/3/19 22:10
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[] {4, 3, 6, 2, 1, 8, 5};
        System.out.println(JSON.toJSONString(insertionSort(array)));
    }

    private static int[] insertionSort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        for (int begin = 1; begin < array.length; begin++) {
            int current = begin;
            while (current > 0 && array[current] < array[current - 1]) {
                int tmp = array[current];
                array[current] = array[current - 1];
                array[current - 1] = tmp;
                current--;
            }
        }
        return array;
    }
}
