package com.wenyao.leetcode.hash;

import java.util.Arrays;

/**
 * @author wenyao
 * @Description 有效的字母异位词
 * @Date 2021/3/7 上午10:47
 */
public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

}
