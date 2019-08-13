package com.wenyao.swordtooffer.array;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 合并两个有序数组并去重
 * @Author: wy
 * @CreateDate: 2019/5/19 13:49
 */
public class SwordToOffer99 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{3, 4, 5};
        int[] c = mergeArray(a, b);
        int zeroCount = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 0) {
                zeroCount++;
            }
        }
        int[] result = new int[c.length - zeroCount];
        for (int i = 0; i < result.length; i++) {
            result[i] = c[i];
        }
        System.out.println(JSON.toJSONString(result));
    }

    private static int[] mergeArray(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, size = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                c[size++] = a[i];
                i++;
                j++;
            } else {
                c[size++] = a[i] > b[j] ? b[j++] : a[i++];
            }
        }
        while (i < a.length) {
            c[size++] = a[i++];
        }
        while (j < b.length) {
            c[size++] = b[j++];
        }
        return c;
    }
}
