package com.wenyao.leetcode.recursion;


import lombok.extern.slf4j.Slf4j;

/**
 * 尾调用:一个函数的最后一个动作是另一个函数的调用（n * method(n-1) 则不是尾调用，最后一个动作是*而不是函数调用）
 * 尾递归：尾调用的函数是此函数自身被称为尾递归，一些编译器会对尾调用进行优化，已达到节省栈空间的目的
 */
@Slf4j
public class TailCallDemo {

    public static void main(String[] args) {

    }

    // 阶乘-尾递归 时间复杂度O(n) 空间复杂度：O(n)
    private static int factorial(int n) {
        return factorial(n, 1);
    }

    private static int factorial(int n, int result) {
        if (n <= 1) {
            return result;
        }
        return factorial(n - 1, n * result);
    }

    // 斐波拉切数列-尾递归
    private static int fib(int n) {
        return fib(n, 1, 1);
    }

    private static int fib(int n, int first, int second) {
        if (n <= 1) {
            return first;
        }
        return fib(n - 1, second, first + second);
    }
}
