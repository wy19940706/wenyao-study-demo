package com.wenyao.swordtooffer.array;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 找出数组中任意一个重复的数字
 * @Author: wy
 * @CreateDate: 2019/3/22 23:19
 */
public class SwordToOffer2 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 2, 3, 4};
        System.out.println(JSON.toJSONString(duplicate(array)));
    }

    private static Integer duplicate(int[] array) {
        for (int i = 0; i < array.length; i++) {
            while (array[i] != i) {
                if (array[i] == array[array[i]]) {
                    return array[i];
                }
                swap(array, i, array[i]);
            }
        }
        return null;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
