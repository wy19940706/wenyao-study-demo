package com.wenyao.studydemo;

import com.google.common.collect.Lists;

import java.util.List;

public class SubListTest {
    public static void main(String[] args) {
        List<Integer> list1 = Lists.newArrayList(1, 2);
        List<Integer> list2 = Lists.newArrayList(list1);
        List<Integer> list3 = list1.subList(0, list1.size());
        list3.add(3);
        System.out.println(list1.equals(list2));
        System.out.println(list1.equals(list3));
    }
}
