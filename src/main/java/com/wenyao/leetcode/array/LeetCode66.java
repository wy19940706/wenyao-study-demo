package com.wenyao.leetcode.array;

/**
 * @author wenyao
 * @Description 下一个数
 * @Date 2021/3/6 下午1:35
 */
public class LeetCode66 {
    public static void main(String[] args) {

    }

    // 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一
    // 输入：digits = [1,2,3]
    // 输出：[1,2,4]
    // 解释：输入数组表示数字 123
    class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] = digits[i] % 10;
                if (digits[i] != 0) {
                    return digits;
                }
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }

}
