package com.wenyao.leetcode.string;

/**
 * @Description: 字符串转整数
 * @Author: wy
 * @CreateDate: 2019/4/4 15:20
 */
public class StrToInt {
    public static void main(String[] args) {
        System.out.println(strToInt(" 1233333333333333333333333333"));
    }

    private static int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean isNegative = str.charAt(0) == '-' ? true : false;
        int result = 0;
        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i == 0 && (ch == '+' || ch == '-' || ch == ' ')) {
                continue;
            }
            if (ch > '9' || ch < '0') {
                return 0;
            }
            result = result * 10 + (ch - '0');
            length++;
            if (length > 10) {
                break;
            }
        }
        if (isNegative) {
            return -result < Integer.MIN_VALUE ? Integer.MIN_VALUE : -result;
        }
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result;
    }
}
