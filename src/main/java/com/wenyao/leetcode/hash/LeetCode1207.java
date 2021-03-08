package com.wenyao.leetcode.hash;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wenyao
 * @Description 独一无二的出现次数
 * @Date 2021/3/7 上午10:55
 */
public class LeetCode1207 {

    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == map.values().size();
    }
}
