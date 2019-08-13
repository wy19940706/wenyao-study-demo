package com.wenyao.stringdemo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description: 分割回文字符串
 * @Author: wy
 * @CreateDate: 2019/4/4 11:31
 */
public class Partition {

    private static List<List<String>> result = Lists.newArrayList();

    public static void main(String[] args) {
        String str = "aab";
        System.out.println(JSON.toJSONString(partition(str)));
    }

    private static List<List<String>> partition(String string) {
        if (string == null || string.length() == 0) {
            return result;
        }
        dfs(string, Lists.newArrayList(), 0);
        return result;
    }

    private static void dfs(String string, List<String> remain, int left) {
        if (left == string.length()) {//判断终止条件
            result.add(Lists.newArrayList(remain));//添加到结果中
            return;
        }

        for (int right = left; right < string.length(); right++) {//从left开始，依次判断left->right是不是回文串
            if (isPalindroom(string, left, right)) {//判断是否是回文串
                remain.add(string.substring(left, right + 1));//添加当前回文串到list中
                dfs(string, remain, right + 1);//从right+1开始继续递归，寻找回文串
                remain.remove(remain.size() - 1);//回溯，从而寻找更长的回文串
            }
        }
    }

    /**
     * 判断是否是回文串
     *
     * @param string
     * @param left
     * @param right
     * @return
     */
    private static boolean isPalindroom(String string, int left, int right) {
        while (left < right && string.charAt(left) == string.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }
}
