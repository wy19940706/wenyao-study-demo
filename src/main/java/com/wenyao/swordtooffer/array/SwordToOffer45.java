package com.wenyao.swordtooffer.array;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 连续子数组的最大和(贪心算法)
 * @Author: wy
 * @CreateDate: 2019/3/24 0:50
 */
public class SwordToOffer45 {
    public static void main(String[] args) {
        int[] array = new int[]{6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(JSON.toJSONString(findGreatestSumOfSubArray(array)));
    }

    private static int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int bigestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum <= 0 ? array[i] : sum + array[i];
            bigestSum = Math.max(bigestSum, sum);
        }
        return bigestSum;
    }
}
