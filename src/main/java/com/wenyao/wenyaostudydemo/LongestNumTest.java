package com.wenyao.wenyaostudydemo;

/**
 * 求一个字符串的最大数字串（abc123.456.789）(包含小数点)
 */
public class LongestNumTest {

    public static void main(String[] args) {
        String str = "abc1a23.ab6.78999.2233333";
        System.out.println(getLongestNum(str));
    }

    private static String getLongestNum(String str) {
        String result = "";
        if (str == null || "".equals(str)) {
            return result;
        }
        char[] chars = str.toCharArray();
        int start = 0, max = 0, index;
        for (int i = 0; i < chars.length; i++) {
            index = i;
            if (chars[i] >= '0' && chars[i] <= '9') {

            } else if (chars[i] == '.') {
                result = str.substring(start + 1, index);
            } else {
                start = i;
            }
            max = Math.max(max, index - start);
        }
        return result;
    }
}
