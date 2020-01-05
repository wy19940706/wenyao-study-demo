package com.wenyao.swordtooffer.bitoperation;

/**
 * @Description: 第一个只出现一次的字符的位置
 * @Author: wy
 * @CreateDate: 2019/4/2 22:07
 */
public class SwordToOffer49 {
    public static void main(String[] args) {
        String str = "aabbcdd";
        System.out.println(firstOfNoRepeatNum(str));
    }

    private static int firstOfNoRepeatNum(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] array = new int[256];
        for (int i = 0; i < str.length(); i++) {
            array[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (array[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

}
