package com.wenyao.leetcode.num;

/**
 * @Description: Sqrt（求平方根）
 * @Author: wy
 * @CreateDate: 2019/3/15 15:53
 */
public class LeetCode69 {
    public static void main(String[] args) {
        System.out.println(sqrt(16));
    }

    private static int sqrt(int target) {
        if (target <= 1) {
            return target;
        }
        int low = 0;
        int high = target;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (mid * mid == target) {
                return (int) mid;
            } else if (mid * mid < target) {
                low = (int) (mid + 1);
            } else {
                high = (int) (mid - 1);
            }
        }
        return high;
    }
}
