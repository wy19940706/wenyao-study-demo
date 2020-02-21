package com.wenyao.leetcode.string;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description: 单词分割->给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词
 * @Author: wy
 * @CreateDate: 2019/4/4 14:52
 */
public class WordBreak {
    public static void main(String[] args) {
        String string = "I am a developer";
        List<String> wordDict = Lists.newArrayList("I", "am", "a", "developer");
        System.out.println(wordBreak(string, wordDict));
    }

    private static boolean wordBreak(String string, List<String> dictionary) {
        int n = string.length();
        int maxLength = 0;
        for (String temp : dictionary) {
            maxLength = temp.length() > maxLength ? temp.length() : maxLength;
        }
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0 && maxLength >= i - j; j--) {
                if (memo[j] && dictionary.contains(string.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }
}
