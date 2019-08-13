package com.wenyao.swordtooffer.array;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @Description: 把数组排成最小的数
 * @Author: wy
 * @CreateDate: 2019/3/24 0:54
 */
public class SwordToOffer47 {
    public static void main(String[] args) {
        int[] array = new int[]{3, 32, 321};
        System.out.println(JSON.toJSONString(printMinNum(array)));
    }

    private static String printMinNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i] + "";
        }
        Arrays.sort(array, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }
}
