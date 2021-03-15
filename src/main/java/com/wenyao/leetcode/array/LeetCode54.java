package com.wenyao.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenyao
 * @Description 螺旋矩阵
 * @Date 2021/3/6 下午1:42
 */
public class LeetCode54 {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }

    // 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
    // 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    // 输出：[1,2,3,6,9,8,7,4,5]
    public static List<Integer> spiralOrder(int[][] matrix) {
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        List<Integer> list = new ArrayList<>();
        int total = matrix.length * matrix[0].length;
        int num = 1;
        while (num <= total) {
            for (int i = l; i <= r && num <= total; i++) { // 从左到右
                list.add(matrix[t][i]);
                num++;
            }
            t++;
            for (int i = t; i <= b && num <= total; i++) { // 从上到下
                list.add(matrix[i][r]);
                num++;
            }
            r--;
            for (int i = r; i >= l && num <= total; i--) { // 从右到左
                list.add(matrix[b][i]);
                num++;
            }
            b--;
            for (int i = b; i >= t && num <= total; i--) { // 从下到上
                list.add(matrix[i][l]);
                num++;
            }
            l++;
        }
        return list;
    }

}
