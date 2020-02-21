package com.wenyao.leetcode.array;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description: 顺时针打印矩阵
 * @Author: wy
 * @CreateDate: 2019/3/22 23:19
 */
public class SwordToOffer34 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        System.out.println(JSON.toJSONString(printMatrix(matrix)));
    }

    private static List<Integer> printMatrix(int[][] matrix) {
        int row1 = 0, row2 = matrix.length - 1, col1 = 0, col2 = matrix[0].length - 1;
        List<Integer> result = Lists.newArrayList();
        while (row1 <= row2 && col1 <= col2) {
            for (int i = col1; i <= col2; i++) {
                result.add(matrix[row1][i]);
            }
            for (int i = row1 + 1; i <= row2; i++) {
                result.add(matrix[i][col2]);
            }
            if (row1 != row2) {
                for (int i = col2 - 1; i >= col1; i--) {
                    result.add(matrix[row2][i]);
                }
            }
            if (col1 != col2) {
                for (int i = row2 - 1; i > row1; i--) {
                    result.add(matrix[i][col1]);
                }
            }
            row1++;
            row2--;
            col1++;
            col2--;
        }
        return result;
    }
}
