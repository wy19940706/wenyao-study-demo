package com.wenyao.leetcode.recall;

import java.util.List;

import com.google.common.collect.Lists;

import cn.hutool.core.util.StrUtil;

/**
 * 电话号码的字母组合 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 示例: 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LeetCode17 {
    public static void main(String[] args) {
        String digits = "234";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> result = Lists.newArrayList();
    // 建立数字与字母字符串的映射
    private static String[] digitStrArray = {" ", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    private static List<String> letterCombinations(String digits) {
        if (StrUtil.isBlank(digits)) {
            return result;
        }
        // 从digits字符串的第0个字符开始找字符存放到str
        generateLetterCombinations(digits, 0, "");
        return result;
    }

    private static void generateLetterCombinations(String digits, int index, String str) {
        if (digits.length() == index) {
            result.add(str);
            return;
        }
        // 获取对应下标的数字 2
        char digit = digits.toCharArray()[index];
        // 数字对应的字符串 abc
        String letterStr = digitStrArray[digit - '0'];
        for (int i = 0; i < letterStr.length(); i++) {
            generateLetterCombinations(digits, index + 1, str + letterStr.charAt(i));
        }
    }


}
