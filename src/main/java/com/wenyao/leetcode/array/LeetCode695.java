package com.wenyao.leetcode.array;

/**
 * 岛屿的最大面积（字节跳动）
 */
class LeetCode695 {
    int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0; // 记录最大岛屿面积
        boolean[][] visited = new boolean[grid.length][grid[0].length]; // 记录当前坐标是否已被访问
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) { //
                    int count = dfs(grid, visited, i, j, 0);
                    max = max > count ? max : count;
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, boolean[][] visited, int x, int y, int count) {
        if (!valid(grid, visited, x, y)) {
            return count;
        }
        visited[x][y] = true;
        for (int i = 0; i < move.length; i++) { // 上下左右进行遍历
            count = dfs(grid, visited, x + move[i][0], y + move[i][1], count);
        }
        return count + 1; // 更新岛屿面积
    }

    private boolean valid(int[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] != 1) {
            // 验证合法性，未越界且未被访问值为1
            return false;
        }
        return true;
    }
}
