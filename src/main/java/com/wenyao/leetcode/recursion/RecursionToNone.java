package com.wenyao.leetcode.recursion;

import java.util.Stack;

/**
 * 递归转非递归：递归转非递归的万能方法，自己去维护一个栈用来模拟递归的栈桢，每个递归一定可以转成非递归(但是空间复杂度依旧没有降低)
 */
public class RecursionToNone {

    private static class Frame {
        int n;
        int v;

        public Frame(int n, int v) {
            this.n = n;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        logOne(4);
        logTwo(4);
        logThree(4);
    }

    // 时间复杂度：O(n) 空间复杂度：O(n)
    private static void logOne(int n) {
        if (n < 1) {
            return;
        }
        logOne(n - 1);
        int v = n + 10;
        System.out.println(v);
    }

    // 时间复杂度：O(n) 空间复杂度：O(n)
    private static void logTwo(int n) {
        Stack<Frame> frameStack = new Stack<>();
        while (n > 0) {
            frameStack.push(new Frame(n, n + 10));
            n--;
        }
        while (!frameStack.isEmpty()) {
            Frame frame = frameStack.pop();
            System.out.println(frame.v);
        }
    }

    // 时间复杂度：O(n) 空间复杂度：O(1)
    private static void logThree(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(n + 10);
        }
    }
}
