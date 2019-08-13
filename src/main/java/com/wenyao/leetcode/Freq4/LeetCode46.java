package com.wenyao.leetcode.Freq4;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description: 给定一个不重复的数组，返回所有的全排列
 * @Author: wy
 * @CreateDate: 2019/3/5 13:01
 */
public class LeetCode46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = Lists.newArrayList();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(res, new boolean[nums.length], nums, Lists.newArrayList());
        return res;
    }

    private static void dfs(List<List<Integer>> res, boolean[] used, int[] nums, List<Integer> item) {
        if (item.size() == nums.length) {
            res.add(Lists.newArrayList(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                item.add(nums[i]);
                dfs(res, used, nums, item);
                item.remove(item.size() - 1);
                used[i] = false;
            }
        }
    }

}
