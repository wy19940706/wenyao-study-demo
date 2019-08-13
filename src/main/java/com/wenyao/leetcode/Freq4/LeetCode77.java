package com.wenyao.leetcode.Freq4;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description: Combine:给定两个整数 n 和 k，返回 1 … n 中所有可能的 k 个数的组合
 * @Author: wy
 * @CreateDate: 2019/3/15 15:28
 */
public class LeetCode77 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = Lists.newArrayList();
        if (n < k || n <= 0) {
            return result;
        }
        List<Integer> item = Lists.newArrayList();
        dfs(n, k, 1, item, result);
        return result;
    }

    private static void dfs(int n, int k, int start, List<Integer> item, List<List<Integer>> result) {
        if (item.size() == k) {
            result.add(Lists.newArrayList(item));
            return;
        }
        for (int i = start; i <= n; i++) {
            item.add(i);
            dfs(n, k, i + 1, item, result);
            item.remove(item.size() - 1);
        }
    }
}
