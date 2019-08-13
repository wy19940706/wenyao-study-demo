package com.wenyao.swordtooffer.dp;

/**
 * @Description: 矩形覆盖(斐波拉契数列)
 * @Author: wy
 * @CreateDate: 2019/4/2 23:14
 */
public class SwordToOffer25 {
    public static void main(String[] args) {
        System.out.println(rectCover(10));
    }

    private static int rectCover(int n) {
        if (n < 3) {
            return n;
        }
        return rectCover(n - 1) + rectCover(n - 2);
    }
}
