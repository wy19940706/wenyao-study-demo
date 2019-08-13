package com.wenyao.leetcode.Freq4;

/**
 * @Description: Word Search
 * @Author: wy
 * @CreateDate: 2019/3/14 17:36
 */
public class LeetCode79 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board,"ABCCED"));
        System.out.println(exist(board,"SEE"));
        System.out.println(exist(board,"ABCB"));
    }

    private static boolean exist(char[][] board, String word) {
        if (board == null || board.length < 0 || board[0].length < 0) {
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[] visited = new boolean[rows * cols];
        int[] count = new int[1];
        char[] str = word.toCharArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(board, rows, cols, i, j, str, visited, count)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[][] board, int rows, int cols, int row, int col, char[] str, boolean[] visited, int[] count) {
        boolean flag = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && board[row][col] == str[count[0]]) {
            count[0]++;
            visited[row * cols + col] = true;
            if (count[0] == str.length) {
                return false;
            }
            flag = hasPathCore(board, rows, cols, row + 1, col, str, visited, count) ||
                    hasPathCore(board, rows, cols, row - 1, col, str, visited, count) ||
                    hasPathCore(board, rows, cols, row, col + 1, str, visited, count) ||
                    hasPathCore(board, rows, cols, row, col - 1, str, visited, count);
        }
        if (!flag) {
            count[0]--;
            visited[row * cols + col] = false;
        }
        return flag;
    }

}
