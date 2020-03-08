package com.wenyao.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给定一个字符串，检测它是否是回文对称的，只考虑其中字母与数字的字符。 例如”A man, a plan, a canal: Panama”是回文对称的，”race a
 *               car”不是。
 * @Author: wy
 * @CreateDate: 2019/1/13 22:39
 */
public class LeetCode125 {
    public static void main(String[] args) {
        String stringOne = "abba";
        String stringTwo = "race a car";
        System.out.println(isPalindromeTwo(stringOne));
        System.out.println(isPalindrome(stringOne));
        System.out.println(isPalindromeThree(stringOne));
    }

    private static boolean isPalindrome(String string) {
        char[] chars = string.toCharArray();
        List<Integer> list = new ArrayList<>();
        int fix = 'a' - 'A';
        for (char ch : chars) {
            if (ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                list.add((int) ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                list.add(ch + fix);
            }
        }
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (!list.get(i).equals(list.get(size - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromeThree(String string) {
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (!isLetterOrNumber(string.charAt(left))) {
                left++;
                continue;
            }
            if (!isLetterOrNumber(string.charAt(right))) {
                right++;
                continue;
            }
            if (Character.toLowerCase(string.charAt(left)) != Character.toLowerCase(string.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalindromeTwo(String string) {
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (!isLetterOrNumber(string.charAt(left))) {
                left++;
                continue;
            }
            if (!isLetterOrNumber(string.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(string.charAt(left)) != Character.toLowerCase(string.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isLetterOrNumber(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
            return true;
        }
        return false;
    }
}
