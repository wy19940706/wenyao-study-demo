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
}
