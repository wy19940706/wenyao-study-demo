package com.wenyao.swordtooffer.stack;

import java.util.Stack;

/**
 * Created by Think on 2019/4/15
 */
public class SwordToOffer35 {
    public static void main(String[] args) {

    }

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
