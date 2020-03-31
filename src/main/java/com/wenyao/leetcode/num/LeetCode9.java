package com.wenyao.leetcode.num;

/**
 * 判断一个数是否是回文数
 */
public class LeetCode9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    /**
     * 思路 标签：数学 如果是负数则一定不是回文数，直接返回 false 如果是正数，则将其倒序数值计算出来，然后比较和原数值是否相等 如果是回文数则相等返回 true，如果不是则不相等 false
     * 比如 123 的倒序 321，不相等；121 的倒序 121，相等
     * 
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int cur = 0;
        int num = x;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }
}
