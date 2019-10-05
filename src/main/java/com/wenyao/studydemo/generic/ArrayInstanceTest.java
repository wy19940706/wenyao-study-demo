package com.wenyao.studydemo.generic;

import java.lang.reflect.Array;

/**
 * 泛型数组
 * 
 * @param <T>
 */
public class ArrayInstanceTest<T> {

    private Class<T> tClass;

    public ArrayInstanceTest(Class<T> tClass) {
        this.tClass = tClass;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        return (T[]) Array.newInstance(tClass, size);
    }

    public static void main(String[] args) {
        ArrayInstanceTest<Integer> integerArrayInstanceTest = new ArrayInstanceTest<>(Integer.class);
        Integer[] integers = integerArrayInstanceTest.create(10);
        System.out.println(integers.length);
    }
}
