package com.wenyao.leetcode.array;

/**
 * @Description: 给定一个二维数组和一个数字，查找该数组中是否存在这个数字，数组从左至右递增，从上至下递增
 * @Author: wy
 * @CreateDate: 2019/3/8 11:35
 */
public class SwordToOffer1 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(search(array, 12));
    }

    private static boolean search(int[][] array, int target) {
        int row = array.length - 1;
        int column = 0;
        while ((row >= 0) && column < array[0].length) {
            if (array[row][column] < target) {
                column++;
            } else if (array[row][column] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}
