package com.wenyao.leetcode.tree;

/**
 * @author wenyao
 * @Description 不同的二叉搜索树 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * @Date 2021/3/9 上午12:19
 */
public class LeetCode96 {

    // 输入: 3
    // 输出: 5
    // 解释:
    // 给定 n = 3, 一共有 5 种不同结构的二叉搜索树
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i < n + 1; i++) {
                for (int j = 1; j < i + 1; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }

}
