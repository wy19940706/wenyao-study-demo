package com.wenyao.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原ip地址-递归加回溯（字节跳动题库）
 */
public class LeetCode93 {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    public static List<String> restoreIpAddresses(String string) {
        List<String> result = new ArrayList<>();
        List<String> item = new ArrayList<>();
        backtracking(string, 0, item, result);
        return result;
    }

    // cur : 当前答案，以 String List的形式，最后再join成String形式 例如 [[255],[255],[111],[35]] -> 255.255.111.35
    // pos, 当前扫描到的s的位置， ans最终答案
    private static void backtracking(String string, int pos, List<String> cur, List<String> ans) {
        if (cur.size() >= 4) {
            if (pos == string.length()) {
                ans.add(String.join(".", cur));
            }
            return;
        }
        // 分割得到ip地址的一段后，下一段只能在长度1-3范围内选择
        for (int i = 1; i <= 3; i++) {
            if (pos + i > string.length()) {
                break;
            }
            String segment = string.substring(pos, pos + i);
            // 剪枝条件：不能以0开头，不能大于255
            if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && Integer.parseInt(segment) > 255)) {
                break;
            }
            cur.add(segment);
            // 注意此处传的参数
            backtracking(string, pos + i, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }

}
