package com.wenyao.leetcode.recall;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @Description: subsets
 * 
 *               给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 说明：解集不能包含重复的子集。 示例: 输入: nums = [1,2,3] 输出: [
 *               [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * @Author: wy
 * @CreateDate: 2019/3/14 22:53
 */
public class LeetCode78 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println(subsets(array));
    }

    private static List<List<Integer>> subsets(int[] array) {
        List<List<Integer>> result = Lists.newArrayList();
        if (array == null || array.length <= 0) {
            return result;
        }
        Arrays.sort(array);
        List<Integer> item = Lists.newArrayList();
        // 从i开始，表示每一次会把有i个元素的集合添加到result中
        for (int i = 0; i <= array.length; i++) {
            dfs(array, i, 0, item, result);
        }
        return result;
    }

    private static void dfs(int[] array, int i, int start, List<Integer> item, List<List<Integer>> result) {
        if (item.size() == i) {
            result.add(Lists.newArrayList(item));
            return;
        }
        for (int j = start; j < array.length; j++) {
            item.add(array[j]);
            dfs(array, i, j + 1, item, result);
            item.remove(item.size() - 1);
        }
    }
}
