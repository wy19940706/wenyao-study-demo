package com.wenyao.leetcode.string;

import java.util.Stack;

/**
 * 简化路径（字节跳动题库）
 * 2.先把字符串以"/"为分隔符分割成数组,此时数组有"路径"、""、"."、".."这四种情况;
 * 3.遍历数组,当s[i].equals("..")并且栈不空时pop,当!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."),即s[i]是路径入栈;
 * 4.栈空,返回"/",栈非空,用StringBuffer做一个连接返回即可;
 */
public class LeetCode71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
    }

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            if (!stack.isEmpty() && split[i].equals("..")) {
                stack.pop();
            } else if (!split[i].equals("") && !split[i].equals(".") && !split[i].equals("..")) {
                stack.push(split[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            stringBuilder.append("/").append(stack.get(i));
        }
        return stringBuilder.toString();
    }
}
