package com.wenyao.leetcode.recall;

/**
 * 回溯-八皇后问题
 */
public class EightQueens {

    private static int[] cols;
    private static int ways;

    public static void main(String[] args) {
        placeQueens(8);
    }

    /**
     * 摆放皇后
     *
     * @param n
     */
    private static void placeQueens(int n) {
        if (n < 1) {
            return;
        }
        cols = new int[n];
        place(0);
        System.out.println(n + "皇后一共有：" + ways + "种摆法");
    }

    /**
     * 从第row行开始摆放
     * 
     * @param row
     */

    private static void place(int row) {
        if (row == cols.length) {
            ways++;
            show();
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                cols[row] = col;
                place(row + 1);
            }
        }
    }

    private static void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("----------------");
    }

    /**
     * 判断第row行第col列是否可以摆放皇后
     * @param row
     * @param col
     * @return
     */
    private static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 第col列已经有皇后
            if (cols[i] == col) {
                return false;
            }
            // 判断斜线
            if ((row - i) == Math.abs(col - cols[i])) {
                return false;
            }
        }
        return true;
    }

}
