package com.wenyao.leetcode.array;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 */
public class LeetCode26 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {2, 1, 1, 1, 3, 3, 4, 5}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        List<Integer> result = Lists.newArrayList();
        result.add(nums[0]);
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                result.add(nums[j]);
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(result);
        return i + 1;
    }

}
