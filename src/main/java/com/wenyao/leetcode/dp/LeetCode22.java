package com.wenyao.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 括号生成：递归+动态规划
 */
public class LeetCode22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = Lists.newArrayList();
        if (n < 1) {
            return result;
        }
        dfs(result, n, n, "");
        return result;
    }

    /**
     * @param result 最后的结果集
     * @param left 左括号还有多少个
     * @param right 右括号还有多少个
     * @param current 当前得到的字符串
     */
    // 结论：
    // 当前左右括号都有大于 0 个可以使用的时候，才产生分支；
    // 产生左分支的时候，只看当前是否还有左括号可以使用；
    // 产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支；
    // 在左边和右边剩余的括号数都等于 0 的时候结算。
    private static void dfs(List<String> result, int left, int right, String current) {
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }
        // 此处进行剪枝处理，只有当左括号剩余个数严格小于右括号剩余个数时才行
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(result, left - 1, right, current + "(");
        }
        if (right > 0) {
            dfs(result, left, right - 1, current + ")");
        }
    }

    // 动态规划
    public static List<String> generateParenthesis4Dp(int n) {
        List<String> result = Lists.newArrayList();
        if (n < 1) {
            return result;
        }
        List<List<String>> dp = new ArrayList<>(n);
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(i);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }
}
