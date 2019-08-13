package com.wenyao.studydemo;

import java.lang.reflect.Field;

/**
 * Created by Think on 2019/4/25
 */
public class SwapTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 1;
        Integer b = 2;
        swap(a, b);
        System.out.println("a = " + a + ",b = " + b);
    }

    private static void swap(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        int tmp = a.intValue();
        field.set(a, b);
        field.set(b, new Integer(tmp));
    }
}
