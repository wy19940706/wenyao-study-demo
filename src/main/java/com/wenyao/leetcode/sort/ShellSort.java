package com.wenyao.leetcode.sort;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 希尔排序
 * @Author: wy
 * @CreateDate: 2019/3/19 22:23
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{6, 4, 3, 2, 8, 9, 6, 5, 2};
        System.out.println(JSON.toJSONString(shellSort(array)));
    }

    private static int[] shellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
}
