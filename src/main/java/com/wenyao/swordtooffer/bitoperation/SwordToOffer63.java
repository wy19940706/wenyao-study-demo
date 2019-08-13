package com.wenyao.swordtooffer.bitoperation;

/**
 * @Description: 不用加减乘除做加法
 * @Author: wy
 * @CreateDate: 2019/4/2 22:56
 */
public class SwordToOffer63 {
    public static void main(String[] args) {
        System.out.println(Add(1, 2));
    }

    private static int Add(int a, int b) {
        return b == 0 ? a : Add(a ^ b, (a & b) << 1);
    }
}
