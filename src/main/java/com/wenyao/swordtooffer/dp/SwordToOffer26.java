package com.wenyao.swordtooffer.dp;

/**
 * @Description: 二进制中1的个数(输入一个整数 ， 输出该数二进制表示的1的个数)
 * @Author: wy
 * @CreateDate: 2019/4/2 22:40
 */
public class SwordToOffer26 {
    public static void main(String[] args) {
        System.out.println(NumberOfOne(7));
        System.out.println(NumberOfOne(15));
    }

    private static int NumberOfOne(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}
