package com.wenyao.leetcode.recall;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @Description: 给定一个不重复的数组，返回所有的全排列（递归+回溯） 例如：[1,2,3]->[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1],
 *               [3, 1, 2], [3, 2, 1]]]
 * @Author: wy
 * @CreateDate: 2019/3/5 13:01
 */
public class LeetCode46 {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        System.out.println(permute(nums));
        System.out.println(permuteTwo(nums));
    }

    // 存放最后结果的集合
    private static final int n = 3;
    private static List<List<Integer>> result = Lists.newArrayList();
    private static boolean[] visited = new boolean[n];

    /**
     * 第一种思想
     * 
     * @param nums
     * @return
     */
    private static List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 1) {
            return result;
        }
        // 存放每一次结果的集合
        List<Integer> item = Lists.newArrayList();
        // 从nums的第0个元素开始去找，每找一个元素放入到item集合中
        generatePermute(nums, 0, item);
        return result;
    }

    private static void generatePermute(int[] nums, int index, List<Integer> item) {
        if (item.size() == nums.length) {
            result.add(Lists.newArrayList(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                item.add(nums[i]);
                generatePermute(nums, index + 1, item);
                item.remove(item.size() - 1);
                visited[i] = false;
            }
        }
    }


    /**
     * 第二种思想
     * 
     * @param nums
     * @return
     */
    private static List<List<Integer>> permuteTwo(int[] nums) {
        List<List<Integer>> result = Lists.newArrayList();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> item = Lists.newArrayList();
        dfs(result, new boolean[nums.length], nums, item);
        return result;
    }

    private static void dfs(List<List<Integer>> result, boolean[] used, int[] nums, List<Integer> item) {
        if (item.size() == nums.length) {
            result.add(Lists.newArrayList(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                item.add(nums[i]);
                dfs(result, used, nums, item);
                item.remove(item.size() - 1);
                used[i] = false;
            }
        }
    }

}
