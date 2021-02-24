package com.wenyao.leetcode.find;

/**
 * @Description: 寻找旋转数组的最小数字
 * @Author: wy
 * @CreateDate: 2019/3/25 23:04
 */
public class LeetCode153 {
    public static void main(String[] args) {
        int[] array = new int[] {3, 4, 5, 1, 2};
        System.out.println(minArray(array));
    }

    public static int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else if (numbers[mid] < numbers[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return numbers[low];
    }

}
