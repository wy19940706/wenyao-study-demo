package com.wenyao.leetcode.num;

/**
 * @Description 汉明距离
 * @author wenyao
 * @Date 2021/3/2 下午11:09
 */
public class LeetCode461 {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1) {
                distance += 1;
            }
            xor = xor >> 1;
        }
        return distance;
    }

}
