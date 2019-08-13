package com.wenyao.swordtooffer.dp;

import java.util.Arrays;

/**
 * @Description: 变态跳台阶
 * @Author: wy
 * @CreateDate: 2019/4/2 23:02
 */
public class SwordToOffer24 {
    public static void main(String[] args) {
        System.out.println(jumpFloorII(3));
        System.out.println(jumpFloorII2(3));
    }

    private static int jumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }

    private static int jumpFloorII2(int target) {
        return (int) Math.pow(2, target - 1);
    }
}
