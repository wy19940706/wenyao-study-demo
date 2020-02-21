package com.wenyao.leetcode.recall;

import java.util.List;

import com.google.common.collect.Lists;

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
        if (n <= 0 || n < k) {
            return result;
        }
        List<Integer> item = Lists.newArrayList();
        // 这个函数的意思是求n中所有可能的k个数的组合，从第1个元素开始，把第i个数字放到item集合里面去，然后所有的item集合放到result集合中去
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
