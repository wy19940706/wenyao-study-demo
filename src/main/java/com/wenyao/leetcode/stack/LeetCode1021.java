package com.wenyao.leetcode.stack;

/**
 * @author wenyao
 * @Description 删除最外层的括号
 * @Date 2021/3/8 下午11:00
 */
public class LeetCode1021 {

    // 输入："(()())(())"
    // 输出："()()()"
    // 解释：
    // 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
    // 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
    public String removeOuterParentheses(String S) {
        int level = 0;
        StringBuilder sb = new StringBuilder();
        for (char character : S.toCharArray()) {
            if (character == ')') {
                --level;
            }
            if (level >= 1) {
                sb.append(character);
            }
            if (character == '(') {
                ++level;
            }
        }
        return sb.toString();
    }
}
