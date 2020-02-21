package com.wenyao.leetcode.array;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 连续子数组的最大和(贪心算法)
 * @Author: wy
 * @CreateDate: 2019/3/24 0:50
 */
public class SwordToOffer45 {
    public static void main(String[] args) {
        int[] array = new int[] {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(JSON.toJSONString(findGreatestSumOfSubArray(array)));
    }

    private static int findGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > 0) {
                array[i] += array[i - 1];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
