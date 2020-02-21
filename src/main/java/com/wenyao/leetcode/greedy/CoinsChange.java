package com.wenyao.leetcode.greedy;

import java.util.Arrays;

/**
 * 兑换零钱（贪心算法）
 */
public class CoinsChange {
    public static void main(String[] args) {
        System.out.println(changeCoins(new int[] {25, 10, 5, 1}, 41));
    }

    private static int changeCoins(int[] faces, int money) {
        Arrays.sort(faces);
        int coins = 0;
        int index = faces.length - 1;
        while (index >= 0) {
            while (money >= faces[index]) {
                System.out.println("需要的面值：" + faces[index]);
                money -= faces[index];
                coins++;
            }
            index--;
        }
        return coins;
    }
}
