package com.wenyao.swordtooffer.find;

/**
 * @Description: 旋转数组的最小数字
 * @Author: wy
 * @CreateDate: 2019/3/25 23:04
 */
public class SwordToOffer21 {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 1, 2};
        System.out.println(minNumInRotateArray(array));
    }

    private static int minNumInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int low = 0, high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] == array[low] && array[high] == array[mid]) {
                return minNumber(array, low, high);
            } else if (array[mid] <= array[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return array[low];
    }

    private static int minNumber(int[] array, int low, int high) {
        for (int i = low; i < high; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[low];
    }
}
