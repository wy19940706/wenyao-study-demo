package com.wenyao.leetcode.Freq5;

import java.util.Stack;

/**

* @Description:    模式匹配

* @Author:         wy

* @CreateDate:     2019/1/9 10:29

*/
public class LeetCode20 {
    public static void main(String[] args) {
        String str1 = "[{([])}]";
        String str2 = "[{([])";
        boolean isValid = isValidOfStr(str1);
        boolean isValid2 = isValidOfStr(str2);
        System.out.println(isValid);
        System.out.println(isValid2);
    }

    private static boolean isValidOfStr(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> characterStack = new Stack<Character>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '[' || c == '{' || c == '(') {
                characterStack.push(c);
            } else {
                if (characterStack.size() == 0) {
                    return false;
                }
                char lastChar = characterStack.peek();
                if (c == ']' && lastChar != '[') {
                    return false;
                }
                if (c == '}' && lastChar != '{') {
                    return false;
                }
                if (c == ')' && lastChar != '(') {
                    return false;
                }
                characterStack.pop();
            }
        }
        if (!characterStack.isEmpty()) {
            return false;
        }
        return true;
    }


}
