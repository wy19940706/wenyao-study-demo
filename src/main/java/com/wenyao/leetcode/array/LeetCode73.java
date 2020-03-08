package com.wenyao.leetcode.array;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 二维数组行列置0
 * @Author: wy
 * @CreateDate: 2019/3/13 23:21
 */
public class LeetCode73 {
    public static void main(String[] args) {
        int[][] matrix = {{4, 5, 2, 1, 0}, {0, 2, 3, 7, 9}, {1, 4, 3, 2, 8}, {6, 1, 3, 4, 5}, {1, 6, 0, 8, 4}};
        setZeroes(matrix);
        System.out.println(JSON.toJSONString(matrix));
    }

    private static void setZeroes(int[][] matrix) {
        int rawLength = matrix.length;
        int colLength = matrix[0].length;
        boolean[] rawFlags = new boolean[rawLength];
        boolean[] colFlags = new boolean[colLength];
        for (int i = 0; i < rawLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    rawFlags[i] = true;
                    colFlags[j] = true;
                }
            }
        }
        // 调整每一行置0
        for (int i = 0; i < rawLength; i++) {
            if (rawFlags[i]) {
                for (int j = 0; j < colLength; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 调整每一列置0
        for (int i = 0; i < colLength; i++) {
            if (colFlags[i]) {
                for (int j = 0; j < rawLength; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    class Solution {
        public void setZeroes(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            boolean rowZeroFlag = false;
            boolean colZeroFlag = false;
            // 第一行是否有零
            for (int j = 0; j < col; j++) {
                if (matrix[0][j] == 0) {
                    rowZeroFlag = true;
                    break;
                }
            }
            // 第一列是否有零
            for (int i = 0; i < row; i++) {
                if (matrix[i][0] == 0) {
                    colZeroFlag = true;
                    break;
                }
            }
            // 把第一行第一列作为标志位
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }
            // 置0
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (rowZeroFlag) {
                for (int j = 0; j < col; j++) {
                    matrix[0][j] = 0;
                }
            }
            if (colZeroFlag) {
                for (int i = 0; i < row; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }

}
