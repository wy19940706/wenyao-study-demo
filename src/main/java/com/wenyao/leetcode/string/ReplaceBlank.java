package com.wenyao.leetcode.string;

/**
 * Created by Think on 2019/5/2
 */
public class ReplaceBlank {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("hello world");
        System.out.println(replaceBlank(stringBuffer));
    }

    private static String replaceBlank(StringBuffer stringBuffer) {
        int p1 = stringBuffer.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (stringBuffer.charAt(i) == ' ') {
                stringBuffer.append(" ");
            }
        }
        int p2 = stringBuffer.length() - 1;
        while (p1 >= 0 && p2 > p1) {
            char ch = stringBuffer.charAt(p1--);
            if (ch == ' ') {
                stringBuffer.setCharAt(p2--, '0');
                stringBuffer.setCharAt(p2--, '2');
                stringBuffer.setCharAt(p2--, '%');
            } else {
                stringBuffer.setCharAt(p2--, ch);
            }
        }
        return stringBuffer.toString();
    }
}
