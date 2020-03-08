package com.wenyao.leetcode.interval;

import java.util.ArrayList;
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

    private static class Interval {
        int start;
        int end;

        public Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int[] toArray() {
            return new int[] {this.start, this.end};
        }
    }

    public static int[][] merge(int[][] intervals) {
        List<Interval> result = Lists.newArrayList();
        for (int[] interval : intervals) {
            result.add(new Interval(interval));
        }
        int i = 0;
        List<Interval> intervals1 = mergeInteval(result);
        int[][] ans = new int[intervals1.size()][2];
        for (Interval interval : intervals1) {
            ans[i] = interval.toArray();
            i++;
        }
        return ans;
    }

    private static List<Interval> mergeInteval(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        // 先做一个区间的start下标排序
        intervals.sort(Comparator.comparingInt(o -> o.start));
        Interval intervalOne = intervals.get(0);
        List<Interval> result = Lists.newArrayList();
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            // 如果第一个区间的end也比第二个的start小，则直接把第一个加入result
            if (intervalOne.end < interval.start) {
                result.add(intervalOne);
                intervalOne = interval;
            } else {
                // 否则肯定第二个的start肯定就在第一个中，所有这个时候确定了start,end用两个区间的end的最大值
                intervalOne = new Interval(intervalOne.start, Math.max(interval.end, intervalOne.end));
            }
        }
        // 把最后一个加入结果
        result.add(intervalOne);
        return result;
    }

}
