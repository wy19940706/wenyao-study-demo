package com.wenyao.leetcode.string;

/**
 * @Description: 字符串匹配-KMP
 * @Author: wy
 * @CreateDate: 2019/1/13 22:08
 */
public class KMP {
    public static void main(String[] args) {
        String haystack = "bcabc";
        String needle = "abc";
        System.out.println(strStr(haystack, needle));
    }

    private static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = getNext(needle);
        int index = -1;
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i - j;
                }
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j];
                }
            }
        }
        return index;
    }

    private static int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = 0;
        if (needle.length() == 1) {
            return next;
        }
        next[1] = 0;
        int i = 1;
        int j = 0;
        while (i < needle.length() - 1) {
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
                if (needle.charAt(i) == needle.charAt(j)) {
                    next[i] = next[j - 1];
                } else {
                    next[i] = j;
                }
            } else {
                if (j == 0) {
                    i++;
                    next[i] = 0;
                } else {
                    j = next[j];
                }
            }
        }
        return next;
    }
}
