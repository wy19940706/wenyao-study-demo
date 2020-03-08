package com.wenyao.leetcode.string;

/**
 * 求出字符串数组的最长公共前缀
 */
public class LeetCode14 {
    public static void main(String[] args) {
        String[] strings = new String[] {"abc", "ab", "abcd"};
        System.out.println(longestCommonPrefix(strings));
    }

    /**
     * 时间复杂度：O(s) s为所有字符串长度之和
     * 
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < result.length() && j < strs[i].length(); j++) {
                if (result.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            result = result.substring(0, j);
            if (result.equals("")) {
                return result;
            }
        }
        return result;
    }
}
