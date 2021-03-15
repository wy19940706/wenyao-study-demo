package com.wenyao.leetcode.find;

import java.util.Arrays;

/**
 * @Description: 二分查找
 * @Author: wy
 * @CreateDate: 2019/3/19 22:53
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[] {3, 4, 6, 5, 5, 2, 1, 8, 9};
        Arrays.sort(array);
        System.out.println(binarySearch(array, 5));
        System.out.println(binarySearchRight(array, 5));
        System.out.println(binarySearchLeft(array, 5));
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;// 取n-1
        while (low <= high) {// 取等于
            // 用减法而不用加法防止数组越界
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else if (array[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }

    // 找左边界
    private static int binarySearchLeft(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;// 取n-1
        while (low <= high) {// 取等于
            // 用减法而不用加法防止数组越界
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {// 别返回 收缩右边界 锁定左边界
                high = mid - 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else if (array[mid] > target) {
                high = mid - 1;
            }
        }
        if (low >= array.length || array[low] != target) {
            return -1;
        }
        return low;
    }

    // 找右边界
    private static int binarySearchRight(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;// 取n-1
        while (low <= high) {// 取等于
            // 用减法而不用加法防止数组越界
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {// 别返回 收缩左边界 锁定右边界
                low = mid + 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else if (array[mid] > target) {
                high = mid - 1;
            }
        }
        if (high > array.length || array[high] != target) {
            return -1;
        }
        return high;
    }

}
