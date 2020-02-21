package com.wenyao.leetcode.num;

/**
 * @Description: 有效数字判断(hard)
 * @Author: wy
 * @CreateDate: 2019/3/12 22:10
 */
public class LeetCode65 {
    public static void main(String[] args) {
        System.out.println(isValidNum("2e-10"));
    }

    private static boolean isValidNum(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (ch == '.') {
                if (pointSeen || eSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (ch == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
                numberAfterE = false;
            } else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen && numberAfterE;
    }
}
