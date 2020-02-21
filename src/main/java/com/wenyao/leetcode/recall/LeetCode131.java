package com.wenyao.leetcode.recall;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

/**
 * @Description: 拆分字符串，如"aab"->[["aa","b"],["a","a","b"]]
 * @Author: wy
 * @CreateDate: 2019/3/14 16:31
 */
public class LeetCode131 {

    private static List<List<String>> result = Lists.newArrayList();

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(partition("abbab")));
    }

    private static List<List<String>> partition(String str) {
        if (str == null || str.length() == 0) {
            return result;
        }
        dfs(str, Lists.newArrayList(), 0);
        return result;
    }

    private static void dfs(String str, List<String> remain, int left) {
        // 已经在找空串了，所有直接把之前的结果加入到result中去返回
        if (left == str.length()) {
            result.add(Lists.newArrayList(remain));
            return;
        }
        for (int right = left; right < str.length(); right++) {
            if (isPalindroom(str, left, right)) {
                remain.add(str.substring(left, right + 1));
                dfs(str, remain, right + 1);
                remain.remove(remain.size() - 1);
            }
        }
    }

    private static boolean isPalindroom(String str, int left, int right) {
        while (left < right && str.charAt(left) == str.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }

}
