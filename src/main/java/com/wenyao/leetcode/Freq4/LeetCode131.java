package com.wenyao.leetcode.Freq4;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wenyao.stringdemo.IsPalindroom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 拆分字符串，如"aab"->[["aa","b"],["a","a","b"]]
 * @Author: wy
 * @CreateDate: 2019/3/14 16:31
 */
public class LeetCode131 {

    private static List<List<String>> result = Lists.newArrayList();

    public static void main(String[] args) {

        System.out.println(JSON.toJSONString(partition("aa")));
    }

    private static List<List<String>> partition(String str) {
        if (str == null || str.length() == 0) {
            return result;
        }
        dfs(str, Lists.newArrayList(), 0);
        return result;
    }

    private static void dfs(String str, List<String> remain, int left) {
        if (left == str.length()) {
            result.add(Lists.newArrayList(remain));
            return;
        }
        for (int right = left; right < str.length(); right++) {
            if (isPalindroom(str,left,right)) {
                remain.add(str.substring(left, right + 1));
                dfs(str, remain, right + 1);
                remain.remove(remain.size() - 1);
            }
        }
    }

    private static boolean isPalindroom(String str,int left,int right) {
        if (left < right && str.charAt(left) == str.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }

}
