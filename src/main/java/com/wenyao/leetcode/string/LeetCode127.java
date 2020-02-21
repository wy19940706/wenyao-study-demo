package com.wenyao.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @Description: Given: start = “hit” end = “cog” dict = [“hot”,”dot”,”dog”,”lot”,”log”] As one
 *               shortest transformation is “hit” -> “hot” -> “dot” -> “dog” -> “cog”, return its
 *               length 5.
 * @Author: wy
 * @CreateDate: 2019/3/7 18:34
 */
public class LeetCode127 {
    public static void main(String[] args) {
        Set<String> wordDictionary = new HashSet<>();
        wordDictionary.add("hot");
        wordDictionary.add("dot");
        wordDictionary.add("dog");
        wordDictionary.add("lot");
        wordDictionary.add("log");
        System.out.println(ladderLength("hit", "cog", wordDictionary));
    }

    private static int ladderLength(String beginWord, String endWord, Set<String> wordDictionary) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        if (wordDictionary.contains(beginWord)) {
            wordDictionary.remove(beginWord);
        }
        while (!queue.isEmpty()) {
            String top = queue.poll();
            int length = top.length();
            StringBuilder stringBuilder;
            int level = map.get(top);
            for (int i = 0; i < length; i++) {
                stringBuilder = new StringBuilder(top);
                for (char c = 'a'; c <= 'z'; c++) {
                    stringBuilder.setCharAt(i, c);
                    String tmpStr = stringBuilder.toString();
                    if (tmpStr.equals(top)) {
                        continue;
                    }
                    if (tmpStr.equals(endWord)) {
                        return level + 1;
                    }
                    if (wordDictionary.contains(tmpStr)) {
                        queue.offer(tmpStr);
                        wordDictionary.remove(tmpStr);
                        map.put(tmpStr, level + 1);
                    }
                }
            }
        }
        return 0;
    }
}
