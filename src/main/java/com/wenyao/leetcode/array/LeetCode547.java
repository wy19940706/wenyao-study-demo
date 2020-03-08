package com.wenyao.leetcode.array;

/**
 * 朋友圈的实现
 */
public class LeetCode547 {
    public static void main(String[] args) {

    }

    // 时间复杂度：O(n^2)
    // 空间复杂度：O(n)
    public static int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
