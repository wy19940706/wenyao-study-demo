package com.wenyao.leetcode.string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 字符流中第一个不重复的字符
 * @Author: wy
 * @CreateDate: 2019/3/25 22:46
 */
public class SwordToOffer7 {
    public static void main(String[] args) {
        String str = "google";
        for (int i = 0; i < str.length(); i++) {
            insert(str.charAt(i));
        }
        System.out.println(firstAppearingOnce());
    }

    private static int[] cnts = new int[256];
    private static Queue<Character> queue = new LinkedList<>();

    private static void insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }

    private static char firstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
