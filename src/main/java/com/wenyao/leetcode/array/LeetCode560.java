package com.wenyao.leetcode.array;

import java.util.HashMap;

/**
 * @author wenyao
 * @Description 和为K的子数组
 * @Date 2021/3/6 下午2:43
 */
public class LeetCode560 {

    // 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数
    // 输入:nums = [1,1,1], k = 2
    // 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }



}
