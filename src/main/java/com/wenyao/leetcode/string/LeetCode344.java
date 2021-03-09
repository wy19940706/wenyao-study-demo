package com.wenyao.leetcode.string;

/**
 * @author wenyao
 * @Description 反转字符串
 * @Date 2021/3/7 上午1:11
 */
public class LeetCode344 {

    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }

}
