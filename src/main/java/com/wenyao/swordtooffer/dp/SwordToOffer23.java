package com.wenyao.swordtooffer.dp;

/**
 * @Description: 跳台阶
 * @Author: wy
 * @CreateDate: 2019/4/2 23:09
 */
public class SwordToOffer23 {
    public static void main(String[] args) {
        System.out.println(jumpToFloorByRecursion(4));
    }

    private static int jumpToFloor(int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 1, pre2 = 2;
        int result = 1;
        for (int i = 3; i <= n; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }

    /**
     * 递归方式跳台阶
     * 
     * @param n
     * @return
     */
    private static int jumpToFloorByRecursion(int n) {
        if (n <= 2) {
            return n;
        }
        return jumpToFloorByRecursion(n - 1) + jumpToFloorByRecursion(n - 2);
    }
}
