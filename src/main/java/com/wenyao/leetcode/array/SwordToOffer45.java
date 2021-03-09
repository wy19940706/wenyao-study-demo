package com.wenyao.leetcode.array;

import java.util.Arrays;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 把数组排成最小的数
 * @Author: wy
 * @CreateDate: 2019/3/24 0:54
 */
public class SwordToOffer45 {
    public static void main(String[] args) {
        int[] array = new int[] {3, 32, 321};
        System.out.println(JSON.toJSONString(printMinNum(array)));
    }

    private static String printMinNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] array = new String[nums.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = nums[i] + "";
        }
        Arrays.sort(array, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
        }
        return result.toString();
    }

}
