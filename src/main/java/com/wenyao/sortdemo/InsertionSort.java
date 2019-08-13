package com.wenyao.sortdemo;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 插入排序
 * @Author: wy
 * @CreateDate: 2019/3/19 22:10
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 6, 2, 1, 8, 5};
        System.out.println(JSON.toJSONString(insertionSort(array)));
    }

    private static int[] insertionSort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int current;
        for (int i = 0; i < array.length; i++) {
            current = array[i + 1];
            int preIndex = i;
            if (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}
