package com.wenyao.leetcode.array;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 调整数组顺序使奇数位于偶数前面（leetcode 面试题21）
 * @Author: wy
 * @CreateDate: 2019/3/24 0:44
 */
public class SwordToOffer28 {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4};
        exchange2(array);
        System.out.println(JSON.toJSONString(array));
    }

    private static int[] exchange2(int[] array) {
        int oddCount = 0;
        for (int value : array) {
            if ((value & 1) == 1) {
                oddCount++;
            }
        }
        int i = 0;
        int j = oddCount;
        int[] clone = array.clone();
        for (int num : clone) {
            if ((num & 1) == 1) {
                array[i++] = num;
            } else {
                array[j++] = num;
            }
        }
        return array;
    }

    private static void exchange(int[] array) {
        int oddCount = 0;// 奇数个数
        for (int value : array) {
            if (value % 2 == 1) {
                oddCount++;
            }
        }
        int[] copyArray = array.clone();
        int i = 0, j = oddCount;
        for (int num : copyArray) {
            if (num % 2 == 1) {
                array[i++] = num;
            } else {
                array[j++] = num;
            }
        }
    }
}
