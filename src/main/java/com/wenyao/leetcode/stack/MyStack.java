package com.wenyao.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 一个队列实现栈
 */
public class MyStack {

    private static Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    private static boolean empty() {
        return queue.isEmpty();
    }

    /**
     * 放入栈
     * 
     * @param x
     */
    private static void push(int x) {
        queue.add(x);
    }

    /**
     * 移除栈顶元素
     * 
     * @return
     */
    private static int pop() {
        return shift();
    }

    /**
     * 弹出栈顶元素
     * 
     * @return
     */
    private static int shift() {
        int size = queue.size();
        while (size-- > 1) {
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    /**
     * 获取栈顶元素
     * 
     * @return
     */
    private static int top() {
        int peek = shift();
        queue.add(peek);
        return peek;
    }

}
