package com.wenyao.leetcode.Freq5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    private static int[] getIndexOfTwoNum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[]{i, index};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
