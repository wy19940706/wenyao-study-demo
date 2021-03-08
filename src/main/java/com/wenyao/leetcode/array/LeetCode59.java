package com.wenyao.leetcode.array;

/**
 * @author wenyao
 * @Description 螺旋矩阵II
 * @Date 2021/3/6 下午12:09
 */
public class LeetCode59 {
    public static void main(String[] args) {
        generateMatrix(3);
    }

    // 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
    public static int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) {
                mat[t][i] = num++; // left to right.
            }
            t++;
            for (int i = t; i <= b; i++) {
                mat[i][r] = num++; // top to bottom.
            }
            r--;
            for (int i = r; i >= l; i--) {
                mat[b][i] = num++; // right to left.
            }
            b--;
            for (int i = b; i >= t; i--) {
                mat[i][l] = num++; // bottom to top.
            }
            l++;
        }
        return mat;
    }
}
