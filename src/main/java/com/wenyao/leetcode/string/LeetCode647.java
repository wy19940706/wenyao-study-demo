package com.wenyao.leetcode.string;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 */
public class LeetCode647 {
    public static void main(String[] args) {

    }

    public int countSubstrings(String str) {
        int count = 0;
        int i;
        for (i = 0; i < str.length(); i++) {
            count += countPalindrome(str, i, i);
            count += countPalindrome(str, i, i + 1);
        }
        return count;
    }

    public int countPalindrome(String str, int left, int right) {
        int count = 0;
        while (left >= 0 && right < str.length() && str.charAt(left--) == str.charAt(right++)) {
            count++;
        }
        return count;
    }
}
