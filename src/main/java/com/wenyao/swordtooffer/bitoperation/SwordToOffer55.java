package com.wenyao.swordtooffer.bitoperation;

/**
 * @Description: 数组中只出现一次的数字
 * @Author: wy
 * @CreateDate: 2019/4/2 22:45
 */
public class SwordToOffer55 {
    public static void main(String[] args) {

    }

    private static void findNumsAppearOnce(int[] nums, int[] nums1, int[] nums2) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0) {
                nums1[0] ^= num;
            } else {
                nums2[0] ^= num;
            }
        }
    }
}
