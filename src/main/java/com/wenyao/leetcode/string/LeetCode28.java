package com.wenyao.leetcode.string;

/**
 * @author wenyao
 * @Description 实现strstr()
 * @Date 2021/3/7 上午1:50
 */
public class LeetCode28 {

    public int strStr(String haystack, String needle) {
        int nLength = needle.length(), hLength = haystack.length();

        for (int start = 0; start < hLength - nLength + 1; ++start) {
            if (haystack.substring(start, start + nLength).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

}
