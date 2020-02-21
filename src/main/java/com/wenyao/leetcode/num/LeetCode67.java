package com.wenyao.leetcode.num;

/**
 * @Description: Add Binary(二进制数相加)
 * @Author: wy
 * @CreateDate: 2019/3/17 11:30
 */
public class LeetCode67 {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

    private static String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < maxLen; i++) {
            int tempA = a.length() > i ? a.charAt(a.length() - i - 1) - '0' : 0;
            int tempB = b.length() > i ? b.charAt(b.length() - i - 1) - '0' : 0;
            sb.insert(0, (tempA + tempB + carry) % 2);
            carry = tempA + tempB + carry > 1 ? 1 : 0;
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
