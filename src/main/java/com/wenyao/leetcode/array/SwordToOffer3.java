package com.wenyao.leetcode.array;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 构建乘积数组
 * @Author: wy
 * @CreateDate: 2019/3/22 23:34
 */
public class SwordToOffer3 {
    public static void main(String[] args) {
        int[] A = new int[] {1, 2, 3};
        System.out.println(JSON.toJSONString(multiply(A)));
    }

    private static int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        for (int i = 0, product = 1; i < length; product *= A[i], i++) {
            B[i] = product;
        }
        for (int i = length - 1, product = 1; i >= 0; product *= A[i], i--) {
            B[i] *= product;
        }
        return B;
    }
}
