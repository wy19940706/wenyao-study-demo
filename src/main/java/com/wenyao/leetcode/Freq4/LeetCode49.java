package com.wenyao.leetcode.Freq4;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Description: 变形词, 比如eat\ate\tea，这三种，字符一样，但是顺序不同，就叫anagrams
 * @Author: wy
 * @CreateDate: 2019/3/17 21:42
 */
public class LeetCode49 {
    public static void main(String[] args) {
        String[] strings = {"eat", "ate", "tea", "milk"};
        System.out.println(JSON.toJSONString(anagrams(strings)));
    }

    private static List<String> anagrams(String[] strs) {
        List<String> result = Lists.newArrayList();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = Maps.newHashMap();
        for (String str : strs) {
            char[] tempArray = str.toCharArray();
            Arrays.sort(tempArray);
            String tempStr = new String(tempArray);
            if (map.containsKey(tempStr)) {
                if (map.get(tempStr).size() == 1) {
                    result.add(map.get(tempStr).get(0));
                }
                map.get(tempStr).add(str);
                result.add(str);
            } else {
                List<String> tempList = Lists.newArrayList();
                tempList.add(str);
                map.put(tempStr, tempList);
            }
        }
        return result;
    }
}
