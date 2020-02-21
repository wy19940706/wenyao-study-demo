package com.wenyao.leetcode.recursion;

/**
 * 汉诺塔 其实分 2 种情况讨论即可
 * 当 n == 1时，直接将盘子从 A 移动到 C ,
 * 当 n > 1时，可以拆分成3大步骤
 * 1. 将n–1个盘子从A移动到B
 * 2. 将编号为n的盘子从A移动到C
 * 3. 将n–1个盘子从B移动到C ✓步骤 1 3 明显是个递归调用
 */
public class HanLuoTaDemo {
    public static void main(String[] args) {
        hanoi(3, "A", "B", "C");
    }

    /**
     * 递归主要从三个地方去考虑：把n个盘子从p1挪动到p3,中间柱子是p2（这是第一个就是这个函数要做什么事情）
     * 时间复杂度O(2^n) 空间复杂度：O(n)
     * @return
     */
    private static void hanoi(int n, String p1, String p2, String p3) {
        if (n <= 1) {
            move(n, p1, p3);
            return;
        }
        hanoi(n - 1, p1, p3, p2);
        move(n, p1, p3);
        hanoi(n - 1, p2, p1, p3);
    }

    /**
     * 把第n个盘子从from挪动到to
     *
     * @param n
     * @param from
     * @param to
     */
    private static void move(int n, String from, String to) {
        System.out.println(n + "号盘子从" + from + "挪动到" + to);
    }
}
