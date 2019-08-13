package com.wenyao.leetcode.Freq4;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: subsets
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
        List<Integer> list = Lists.newArrayList();
        if (array == null || array.length <= 0) {
            return result;
        }
        result.add(Lists.newArrayList());
        Arrays.sort(array);
        for (int i = 0; i <= array.length; i++) {
            dfs(array, i, 0, list, result);
        }
        return result;
    }

    private static void dfs(int[] array, int i, int start, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == i) {
            result.add(Lists.newArrayList());
            return;
        }
        for (int j = start; j < array.length; j++) {
            list.add(array[j]);
            dfs(array, i, j + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
