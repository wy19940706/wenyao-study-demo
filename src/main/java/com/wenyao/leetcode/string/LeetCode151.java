package com.wenyao.leetcode.string;

import com.alibaba.dubbo.common.utils.Stack;

/**
 * 翻转字符串 输入: "the sky is blue" 输出: "blue is sky the"
 */
public class LeetCode151 {
    public static void main(String[] args) {
        String str = "a good example";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String string) {
        String[] strings = string.split(" ");
        Stack<String> stringStack = new Stack<>();
        for (String value : strings) {
            if (!value.equals("")) {
                stringStack.push(value);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stringStack.pop());
        while (!stringStack.isEmpty()) {
            stringBuilder.append(" ").append(stringStack.pop());
        }
        return stringBuilder.toString();
    }
}
