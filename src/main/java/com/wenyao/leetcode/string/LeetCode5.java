package com.wenyao.leetcode.string;

/**
 * 最长回文子串(中心扩展算法) 终于看懂了这个中心扩展算法是什么意思了。 先来解释一下为什么中心是2n-1而不是n
 * 比如有字符串abcba，这时回文子串是abcda，中心是c；又有字符串adccda，这时回文子串是adccda，中心是cc。
 * 由此可见中心点既有可能是一个字符，也有可能是两个字符，当中心为一个字符的时候有n个中心，当中心为两个字符的时候有n-1个中心，所以一共有2n-1个中心。
 * 然后for循环开始从左到右遍历，为什么会有两次expandAroundCenter，一次是i和i本身，一次是i和i+1，这就是上面说到的一个中心与两个中心。
 * 而后会去判断这两种情况下谁的回文子串最长，并标记出这个子串在原字符串中的定位，即start和end。
 */
public class LeetCode5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ababa"));
    }

    // 时间复杂度：O（n²）。
    // 空间复杂度：O（1）。
    public static String longestPalindrome(String str) {
        if (str == null || str.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < str.length(); i++) {
            int len1 = expandAroundCenter(str, i, i);
            int len2 = expandAroundCenter(str, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    private static int expandAroundCenter(String str, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < str.length() && str.charAt(L) == str.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
