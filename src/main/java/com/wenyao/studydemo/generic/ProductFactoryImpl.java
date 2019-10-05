package com.wenyao.studydemo.generic;

public class ProductFactoryImpl implements Factory<Integer> {

    @Override
    public Integer create() {
        Integer integer = new Integer(10);
        System.out.println(integer);
        return integer;
    }
}
