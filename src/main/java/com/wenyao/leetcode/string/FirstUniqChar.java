package com.wenyao.leetcode.string;

/**
 * 字符串中第一个不重复的字符
 */
public class FirstUniqChar {
    public static void main(String[] args) {

    }

    public static char firstUniqChar(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i) - 'a'] == 1) {
                return str.charAt(i);
            }
        }
        return ' ';
    }
}
