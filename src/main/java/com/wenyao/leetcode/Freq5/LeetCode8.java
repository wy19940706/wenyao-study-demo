package com.wenyao.leetcode.Freq5;

/**
 * @Description: 实现一个atoi函数来把字符串转换为整型变量
 * @Author: wy
 * @CreateDate: 2019/1/9 10:47
 */
public class LeetCode8 {
    public static void main(String[] args) {
        String str = " 001str";
        String string = " 1233333333333333333333333333";
        System.out.println(myAtoi(string));
        int result = myAtoi(str);
        System.out.println(result);
    }

    private static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        Long result = 0L;
        int startIndex = 0;
        boolean flag = true;//正数
        int length = 0;
        for (int i = 0; i < chars.length; i++) {
            if (startIndex == i) {
                if (chars[i] == ' ') {
                    startIndex++;
                    continue;
                }
                if (chars[i] == '+' || chars[i] == '0') {
                    continue;
                }
                if (chars[i] == '-') {
                    flag = false;
                    continue;
                }
            }
            if (chars[i] >= '0' && chars[i] <= '9') {
                result = result * 10 + chars[i] - '0';
                length++;
                if (length > 10) {
                    break;
                }
            } else {
                break;
            }
        }
        if (flag) {
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        } else {
            result = -result;
            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return result.intValue();
    }

}
