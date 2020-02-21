package com.wenyao.leetcode.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

/**
 * @Description: 合并区间
 * @Author: wy
 * @CreateDate: 2019/3/7 17:10
 */
public class LeetCode56 {
    private static class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Interval intervalOne = new Interval(1, 3);
        Interval intervalTwo = new Interval(2, 6);
        Interval intervalThree = new Interval(8, 10);
        Interval intervalFour = new Interval(15, 18);
        intervals.add(intervalOne);
        intervals.add(intervalTwo);
        intervals.add(intervalThree);
        intervals.add(intervalFour);
        System.out.println(JSON.toJSONString(mergeInteval(intervals)));

    }

    private static List<Interval> mergeInteval(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        Interval intervalOne = intervals.get(0);
        List<Interval> result = Lists.newArrayList();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (intervalOne.end < interval.start) {
                result.add(intervalOne);
                intervalOne = interval;
            } else {
                intervalOne = new Interval(intervalOne.start, Math.max(interval.end, intervalOne.end));
            }
        }
        result.add(intervalOne);
        return result;
    }
}
