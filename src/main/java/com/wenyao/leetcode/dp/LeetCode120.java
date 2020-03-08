package com.wenyao.leetcode.dp;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 三角形最小路径和-字节跳动
 */
public class LeetCode120 {

    public static void main(String[] args) {
        List<Integer> integers = Lists.newArrayList(2);
        List<Integer> integers1 = Lists.newArrayList(3, 4);
        List<Integer> integers2 = Lists.newArrayList(6, 5, 7);
        List<Integer> integers3 = Lists.newArrayList(4, 1, 8, 3);
        List<List<Integer>> res = Lists.newArrayList(integers, integers1, integers2, integers3);
        System.out.println(minimumTotal(res));
    }

    // 时间复杂度：O(n^2) （n 为三角形的总行数）
    // 空间复杂度：O(n^2) （n 为三角形的总行数）
    // 状态定义：dp[i][j]表示包含第i行第j列元素的最小路径和
    // 状态分析
    // 初始化：
    // dp[0][0]=triangle[0][0]
    // 常规：
    // triangle[i][j]一定会经过triangle[i-1][j]或者triangle[i-1][j-1],
    // 所以状态dp[i][j]一定等于dp[i-1][j]或者dp[i-1][j-1]的最小值+triangle[i][j]
    // 特殊：
    // triangle[i][0]没有左上角 只能从triangle[i-1][j]经过
    // triangle[i][row[0].length]没有上面 只能从triangle[i-1][j-1]经过
    // 转换方程：dp[i][j]=min(dp[i-1][j],dp[i-1][j-1])+triangle[i][j]
    public static int minimumTotal(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int row = triangle.size();
        int column = triangle.get(row - 1).size();

        int[][] dp = new int[row][column];
        dp[0][0] = triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;

        for (int i = 1; i < row; i++) {
            // 对每一行的元素进行推导
            for (int j = 0; j <= i; j++) {
                if (j == 0) {// 最左端特殊处理
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {// 最右端特殊处理
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }

        // dp最后一行记录了最小路径
        for (int i = 0; i < column; i++) {
            res = Math.min(res, dp[row - 1][i]);
        }
        return res;
    }

    // 时间复杂度：O(n^2) （n 为三角形的总行数）
    // 空间复杂度(优化版)：O(n) （n 为三角形的总行数）
    public int minimumTotalTwo(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // dp最大长度==triangle底边长度
        // 题意：只使用 O(n) 的额外空间（n 为三角形的总行数）
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);

        // prev暂存dp[i-1][j-1],cur暂存dp[i-1][j]
        int prev = 0, cur;
        for (int i = 1; i < triangle.size(); i++) {
            // 对每一行的元素进行推导
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                cur = dp[j];
                if (j == 0) {
                    // 最左端特殊处理
                    dp[j] = cur + rows.get(j);
                } else if (j == i) {
                    // 最右端特殊处理
                    dp[j] = prev + rows.get(j);
                } else {
                    dp[j] = Math.min(cur, prev) + rows.get(j);
                }
                prev = cur;
            }
        }

        int res = Integer.MAX_VALUE;
        // dp最后一行记录了最小路径
        for (int i = 0; i < triangle.size(); i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }

}
