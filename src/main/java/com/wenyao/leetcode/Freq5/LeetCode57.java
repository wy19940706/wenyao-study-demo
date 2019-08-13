package com.wenyao.leetcode.Freq5;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wenyao.leetcode.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 插入区间
 * @Author: wy
 * @CreateDate: 2019/3/12 21:49
 */
public class LeetCode57 {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(3, 6);
        Interval interval3 = new Interval(5, 8);
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        Interval newInterval = new Interval(4, 7);
        list = insert(list, newInterval);
        System.out.println(JSON.toJSONString(list));
    }

    private static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) {
            return Lists.newArrayList();
        }
        List<Interval> result = Lists.newArrayList();
        for (Interval item : intervals) {
            if (newInterval == null || item.end < newInterval.start) {
                result.add(item);
            } else if (item.start > newInterval.end) {
                result.add(newInterval);
                result.add(item);
                newInterval = null;
            } else {
                newInterval.start = Math.min(item.start, newInterval.start);
                newInterval.end = Math.max(item.end, newInterval.end);
            }
        }
        if (newInterval != null) {
            result.add(newInterval);
        }
        return result;
    }
}
