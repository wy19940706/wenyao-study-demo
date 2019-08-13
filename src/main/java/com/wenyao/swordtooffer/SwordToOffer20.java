package com.wenyao.swordtooffer;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description: 滑动窗口的最大值
 * @Author: wy
 * @CreateDate: 2019/4/2 22:24
 */
public class SwordToOffer20 {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        List<Integer> result = maxInWindows(array, 3);
        System.out.println(JSON.toJSONString(result));
    }

    private static List<Integer> maxInWindows(int[] arrary, int size) {
        List<Integer> result = Lists.newArrayList();
        if (size > arrary.length || size < 1) {
            return result;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            heap.add(arrary[i]);
        }
        result.add(heap.peek());
        for (int i = 0, j = i + size; j < arrary.length; i++, j++) {
            heap.remove(arrary[i]);
            heap.add(arrary[j]);
            result.add(heap.peek());
        }
        return result;
    }
}