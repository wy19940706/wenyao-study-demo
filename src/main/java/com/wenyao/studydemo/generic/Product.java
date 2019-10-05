package com.wenyao.studydemo.generic;

public class Product<T> {
    public <F extends Factory<T>> Product(F factory) {
        factory.create();
    }
}
