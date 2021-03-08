package com.wenyao.leetcode.array;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description 多数元素
 * @author wenyao
 * @Date 2021/3/2 下午11:39
 */
public class LeetCode169 {

    // 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    // 输入：[3,2,3]
    // 输出：3
    public int majorityElement(int[] nums) {
        Map<Integer, Long> map =
                Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long limit = nums.length >> 1;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > limit) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
