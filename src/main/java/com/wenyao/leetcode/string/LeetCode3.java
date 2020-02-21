package com.wenyao.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 求一个字符串的最大不重复子串的长度
 * @Author: wy
 * @CreateDate: 2018/11/14 16:37
 */
public class LeetCode3 {
    public static void main(String[] args) {
        String str = "abcadefb";
        int length = lengthOfLongestSubString(str);
        System.out.println(length);
    }

    /**
     * 求字符串的最大不重复子串长度
     *
     * @return 最大不重复子串的长度
     */
    public static int lengthOfLongestSubString(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        // 当前处理的开始位置
        int start = 0;
        // 记录到的最大非重复子串的长度
        int result = 0;
        // 访问标记，记录最新一次访问的字符和位置
        Map<Character, Integer> findFlag = new HashMap<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // 如果字符已经出现过(在标记开位置算起)，就重新标记start
            if (findFlag.containsKey(ch) && findFlag.get(ch) >= start) {
                start = findFlag.get(ch) + 1;
            } else {
                // 如果没有出现过就求最大的非重复子串的长度
                result = Math.max(result, i - start + 1);
            }
            // 更新记录
            findFlag.put(ch, i);
        }
        System.out.println("最终字符串：" + str.substring(start, start + result));
        return result;
    }

}
