package com.wenyao.studydemo;

import java.util.LinkedList;
import java.util.List;

public class SortedLinkedList {

    private static List<Integer> list = new LinkedList<>();

    private static List<Integer> addElement(Integer element) {
        int i = 0;
        for (Integer j : list) {
            if (element <= j) {
                break;
            }
            ++i;
        }
        list.add(i, element);
        return list;
    }

    public static void main(String[] args) {
        addElement(3);
        addElement(2);
        addElement(1);
        System.out.println(list);
    }

}
