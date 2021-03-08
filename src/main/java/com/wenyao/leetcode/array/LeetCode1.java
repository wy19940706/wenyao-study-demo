package com.wenyao.leetcode.array;

import java.util.Arrays;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @Description: 两数之和
 * @Author: wy
 * @CreateDate: 2019/1/9 10:29
 */
public class LeetCode1 {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 4, 5};
        int target = 3;
        int[] result = getIndexOfTwoNum(intArray, target);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getIndexOfTwoNum(int[] intArray, int target) {
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < intArray.length; i++) {
            Integer integer = map.get(target - intArray[i]);
            if (integer != null) {
                return new int[] {integer, i};
            }
            map.put(intArray[i], i);
        }
        return new int[] {0, 0};
    }

}
