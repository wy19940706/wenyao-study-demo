package com.wenyao.leetcode.array;

/**
 * 机器人能否返回原点
 */
public class LeetCode657 {
    public static void main(String[] args) {

    }

    public static boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return false;
        }
        int[] array = new int[26];
        for (int i = 0; i < moves.length(); i++) {
            array[moves.charAt(i) - 'A']++;
        }
        if (array['R' - 'A'] == array['L' - 'A'] && array['U' - 'A'] == array['D' - 'A']) {
            return true;
        }
        return false;
    }
}
