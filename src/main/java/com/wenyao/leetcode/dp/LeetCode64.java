package com.wenyao.leetcode.dp;

/**
 * 最小路径和-dp
 *  输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class LeetCode64 {
    public static void main(String[] args) {

    }

    // 时间复杂度：O(M*N) 空间复杂度：O(1) 直接使用grid优化空间复杂度为O(1) 因为每次上一个值用过之后就不再关心
    public static int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 左边和上边都是边界，直接continue
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {// 一直在最上边界走
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {// 一直在最左边界走
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
