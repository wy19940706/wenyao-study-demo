package com.wenyao.studydemo;

import java.util.HashMap;
import java.util.Map;

public class HashMapTestDemo {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>(2, 0.75f);
        hashMap.put(5, "C");
        new Thread(() -> {
            hashMap.put(7, "B");
            System.out.println(hashMap);
        }, "Thread1").start();

        new Thread(() -> {
            hashMap.put(3, "A");
            System.out.println(hashMap);
        }, "Thread2").start();

    }
}
