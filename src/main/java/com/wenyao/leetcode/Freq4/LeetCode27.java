package com.wenyao.leetcode.Freq4;

/**
 * @Description: 给定一个数组和一个值，在原地移除所有的这个值的实例，并且返回新的数组长度。
 * 元素的顺序可以被改变。而该数组在超过新长度的部分，可以不去管它。
 * @Author: wy
 * @CreateDate: 2019/3/17 22:11
 */
public class LeetCode27 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4};
        int target = 3;
        System.out.println(removeElement(array, target));
        System.out.println(removeTarget(array, target));
    }

    private static int removeElement(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            while (left <= right && array[left] != target) {
                left++;
            }
            while (left <= right && array[right] == target) {
                right--;
            }
            if (left < right) {
                swap(array, left, right);
                left++;
                right--;
            } else {
                break;
            }
        }
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private static int removeTarget(int[] array, int target) {
        int nextEmpty = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != target) {
                array[nextEmpty] = array[i];
                nextEmpty++;
            }
        }
        return nextEmpty;
    }
}
