package com.wenyao.sortdemo;

import java.util.Arrays;

/**
 * @Description: 二分查找
 * @Author: wy
 * @CreateDate: 2019/3/19 22:53
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[] {3, 4, 6, 5, 2, 1, 8, 9};
        Arrays.sort(array);
        System.out.println(binarySearch(array, 5));
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            // 用减法而不用加法防止数组越界
            int mid = low + (high - low) / 2;
            if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
