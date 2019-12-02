package com.wenyao.studydemo.alibaba;

import java.util.Map;

import com.google.common.collect.Maps;

// 有一个字符串它的构成是词+空格的组合，如“北京 杭州 杭州 北京”， 要求输入一个匹配模式（简单的以字符来写）， 比如 aabb, 来判断该字符串是否符合该模式， 举个例子：
// 1. pattern = "abba", str="北京 杭州 杭州 北京" 返回 ture
// 2. pattern = "aabb", str="北京 杭州 杭州 北京" 返回 false
// 3. pattern = "baab", str="北京 杭州 杭州 北京" 返回 ture
public class MatchPatternTest {
    public static void main(String[] args) {
        String pattern = "baab";
        String string = "北京 杭州 杭州 北京";
        System.out.println(matchWords(pattern, string));
    }

    private static boolean matchWords(String pattern, String string) {
        if (pattern == null || string == null) {
            return false;
        }
        Map<Character, String> patternToWordMap = Maps.newHashMap();
        String[] words = string.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            boolean keyExist = patternToWordMap.containsKey(pattern.charAt(i));
            boolean valueExist = patternToWordMap.containsValue(words[i]);
            String value = patternToWordMap.get(pattern.charAt(i));
            if (keyExist) {
                if (!value.equals(words[i])) {
                    return false;
                }
            } else {
                if (valueExist) {
                    return false;
                } else {
                    patternToWordMap.put(pattern.charAt(i), words[i]);
                }
            }
        }
        return true;
    }

}
