package com.wenyao.leetcode.recursion;

import com.wenyao.leetcode.TimeUtil;

/**
 * 跳台阶(与斐波拉切一致)
 */
public class JumpFloorDemo {

    public static void main(String[] args) {
        TimeUtil.calculateTime("jumpFloorOne", () -> System.out.println(jumpFloorOne(44)));
        TimeUtil.calculateTime("jumpFloorTwo", () -> System.out.println(jumpFloorTwo(44)));
        TimeUtil.calculateTime("jumpFloorThree", () -> System.out.println(jumpFloorThree(44)));
    }

    // 时间复杂度：O(2^n)(每次不断的*2 -> 2^n) 空间复杂度：O(n) 大量重复计算，性能低下
    public static int jumpFloorOne(int n) {
        if (n <= 2) {
            return n;
        }
        return jumpFloorOne(n - 1) + jumpFloorOne(n - 2);
    }

    // 继续优化不使用数组去占用空间 时间复杂度：O(n) 空间复杂度：O(1)
    private static int jumpFloorTwo(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

    public static int jumpFloorThree(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        long first = 1;
        long second = 2;
        for (long i = 3; i <= n; i++) {
            long val = (first + second) % 1000000007;
            first = second;
            second = val;
        }
        return (int) second;
    }
}
