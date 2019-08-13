package com.wenyao.sortdemo;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 二分插入排序
 * @Author: wy
 * @CreateDate: 2019/3/19 0:10
 */
public class BinarySort {
    public static void main(String[] args) {
        int[] array = {3, 2, 1, 5, 4, 6, 2};
        binarySort(array);
        System.out.println(JSON.toJSONString(array));
    }

    private static void binarySort(int[] array) {
        if (array == null) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                int temp = array[i];
                int left = 0;
                int right = i - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (array[mid] < temp) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                for (int j = i; j > left; j--) {
                    array[j] = array[j - 1];
                }
                array[left] = temp;
            }
        }
    }

}
