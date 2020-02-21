package com.wenyao.leetcode.string;

/**
 * @Description: 反转字符串
 * @Author: wy
 * @CreateDate: 2019/4/4 15:13
 */
public class ReverseStr {
    public static void main(String[] args) {
        String str = "abrowc";
        System.out.println(reverseStr(str.toCharArray()));
    }

    private static char[] reverseStr(char[] strArray) {
        if (strArray.length == 0 || strArray == null) {
            return null;
        }
        int i = 0, j = strArray.length - 1;
        while (i < j) {
            swap(strArray, i, j);
            i++;
            j--;
        }
        return strArray;
    }

    private static void swap(char[] array, int i, int j) {
        char temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
