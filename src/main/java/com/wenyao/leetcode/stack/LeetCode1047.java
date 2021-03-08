package com.wenyao.leetcode.stack;

import java.util.Stack;

/**
 * @author wenyao
 * @Description 删除字符串中的所有相邻重复项
 * @Date 2021/3/8 下午10:50
 */
public class LeetCode1047 {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char character : s.toCharArray()) {
            if (stack.isEmpty() || character != stack.peek()) {
                stack.push(character);
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}
