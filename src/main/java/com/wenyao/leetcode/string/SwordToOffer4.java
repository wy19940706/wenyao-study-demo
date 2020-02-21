package com.wenyao.leetcode.string;

/**
 * @Description: 给一个字符串替换空格
 * @Author: wy
 * @CreateDate: 2019/3/8 11:49
 */
public class SwordToOffer4 {
    public static void main(String[] args) {
        System.out.println(replaceAllSpace("hello world, I am a RD"));
    }

    private static String replaceAllSpace(String string) {
        StringBuilder outString = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == ' ') {
                outString.append("%20");
            } else {
                outString.append(ch);
            }
        }
        return outString.toString();
    }
}
