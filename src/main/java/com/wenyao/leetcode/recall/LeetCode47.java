package com.wenyao.leetcode.recall;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。 输入: [1,1,2] 输出: [ [1,1,2], [1,2,1], [2,1,1] ]
 */
public class LeetCode47 {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = Lists.newArrayList();
        if (nums == null || nums.length == 0) {
            return result;
        }
        // 需要先进行排序，方便后续剪枝处理
        Arrays.sort(nums);
        List<Integer> item = Lists.newArrayList();
        boolean[] used = new boolean[nums.length];
        dfs(result, nums, used, item);
        return result;
    }

    private static void dfs(List<List<Integer>> result, int[] nums, boolean[] used, List<Integer> item) {

        if (item.size() == nums.length) {
            result.add(Lists.newArrayList(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // 此处需要进行剪枝处理避免添加重复元素
                // nums[i-1]==nums[i]表示当前选取的数与上一轮选取的数一样
                // 然后加上!used[i-1]表示nums[i-1]刚刚被选取过然后被撤销了，这样就代表这一个过程是重复的，continue
                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                item.add(nums[i]);
                dfs(result, nums, used, item);
                item.remove(item.size() - 1);
                used[i] = false;
            }
        }
    }


}
