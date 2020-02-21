package com.wenyao.leetcode.stack;

import java.util.Stack;

/**
 * @Description: 两个栈实现队列
 * @Author: wy
 * @CreateDate: 2019/3/26 22:32
 */
public class SwordToOffer19 {
    private static Stack<Integer> inStack = new Stack<>();
    private static Stack<Integer> outStack = new Stack<>();

    public static void main(String[] args) {
        push(3);
        int value = pop();
        System.out.println(value);
    }

    private static void push(int value) {
        inStack.push(value);
    }

    private static int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
}
