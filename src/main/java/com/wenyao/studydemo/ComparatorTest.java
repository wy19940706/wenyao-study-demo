package com.wenyao.studydemo;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorTest {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(4, 3, 5, 8, 7, 1);
//        list.sort((o1, o2) -> {
//            if (o1 > o2) {
//                return -1;
//            } else if (o1 < o2) {
//                return 1;
//            } else {
//                return 0;
//            }
//        });
        list.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }).collect(Collectors.toList());
        System.out.println(list);
    }
}
