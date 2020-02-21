package com.wenyao.leetcode.recursion;

import com.wenyao.leetcode.TimeUtil;

/**
 * 斐波拉切数列-各种优化思路
 */
public class FibDemo {

    public static void main(String[] args) {
        TimeUtil.calculateTime("fibOne", () -> System.out.println(fibOne(44)));
        TimeUtil.calculateTime("fibTwo", () -> System.out.println(fibTwo(44)));
        TimeUtil.calculateTime("fibThree", () -> System.out.println(fibThree(44)));
        TimeUtil.calculateTime("fibFour", () -> System.out.println(fibFour(44)));
    }

    // 时间复杂度：O(2^n)(每次不断的*2 -> 2^n) 空间复杂度：O(n) 大量重复计算，性能低下
    public static int fibOne(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibOne(n - 1) + fibOne(n - 2);
    }

    // 时间复杂度：O(n) 空间复杂度：O(n) 不再重复计算
    public static int fibTwo(int n) {
        if (n <= 2) {
            return 1;
        }
        // 分配n+1个是为了抛弃array[0]，更好理解
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        return fibTwo(n - 1, array) + fibTwo(n - 2, array);
    }

    private static int fibTwo(int n, int[] array) {
        // array[n] == 0说明该位置还没有值，进行计算，每次进来只会计算一次 下一次的就会去拿之前计算好的结果，所以时间复杂度降为O(n)
        if (array[n] == 0) {
            return fibTwo(n - 1, array) + fibTwo(n - 2, array);
        }
        // 否则的话直接返回array[n]
        return array[n];
    }

    // 时间复杂度：O(n) 空间复杂度：O(n)
    private static int fibThree(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    // 继续使用滚动数组优化空间复杂度 时间复杂度：O(n) 空间复杂度：O(1)
    private static int fibFour(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            // 这一步始终使用两个位置去放数据
            array[i % 2] = array[(i - 1) % 2] + array[(i - 2) % 2];
        }
        return array[n % 2];
    }

    /**
     * 3 % 2 = 1 = 0b0011 & 1 4 % 2 = 0 = 0b0100 & 1 5 % 2 = 1 = 0b0101 & 1 6 % 2 = 0 = 0b0110 & 1
     * %2的结果就等于该数字 &1
     */
    // 继续使用&1这种二进制运算来代替%2操作提高时间性能 时间复杂度：O(n) 空间复杂度：O(1)
    private static int fibFive(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            // 这一步始终使用两个位置去放数据
            array[i & 1] = array[(i - 1) & 1] + array[(i - 2) & 1];
        }
        return array[n & 1];
    }

    // 继续优化不使用数组去占用空间 时间复杂度：O(n) 空间复杂度：O(1)
    private static int fibSix(int n) {
        if (n <= 2) {
            return 1;
        }
        int first = 1;
        int second = 1;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }


}
