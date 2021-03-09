package com.wenyao.leetcode.stack;

import java.util.Stack;

/**
 * @Description: 两个栈实现队列
 * @Author: wy
 * @CreateDate: 2019/3/26 22:32
 */
public class SwordToOffer9 {

    public class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        int size;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
            size = 0;
        }

        public void appendTail(int value) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(value);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            size++;
        }

        public int deleteHead() {
            if (size == 0) {
                return -1;
            }
            size--;
            return stack1.pop();
        }
    }



}
