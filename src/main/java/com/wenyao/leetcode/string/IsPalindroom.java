package com.wenyao.leetcode.string;

/**
 * @Description: 是否是回文字符串
 * @Author: wy
 * @CreateDate: 2019/4/4 14:45
 */
public class IsPalindroom {
    public static void main(String[] args) {
        System.out.println(isPalindroom("abbaa"));
    }

    private static boolean isPalindroom(String string) {
        if (string.length() == 0) {
            return true;
        }
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (left < right && !isLetterOrDigit(string.charAt(left))) {
                left++;
            }
            if (left < right && !isLetterOrDigit(string.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(string.charAt(left)) != Character.toLowerCase(string.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isLetterOrDigit(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

}
