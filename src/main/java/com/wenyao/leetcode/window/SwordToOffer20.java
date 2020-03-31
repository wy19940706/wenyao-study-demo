package com.wenyao.leetcode.window;

import java.util.List;
import java.util.PriorityQueue;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

/**
 * @Description: 滑动窗口的最大值
 * @Author: wy
 * @CreateDate: 2019/4/2 22:24
 */
public class SwordToOffer20 {
    public static void main(String[] args) {
        int[] array = new int[] {2, 3, 4, 2, 6, 2, 5, 1};
        List<Integer> result = maxInWindows(array, 3);
        System.out.println(JSON.toJSONString(result));
    }

    private static List<Integer> maxInWindows(int[] arrary, int size) {
        List<Integer> result = Lists.newArrayList();
        if (size > arrary.length || size < 1) {
            return result;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            queue.add(arrary[i]);
        }
        result.add(queue.peek());
        for (int i = 0, j = i + size; j < arrary.length; i++, j++) {
            queue.remove(arrary[i]);
            queue.add(arrary[j]);
            result.add(queue.peek());
        }
        return result;
    }
}
