package com.wenyao.studydemo.generic;

public class Client {
    public static void main(String[] args) {
        Product integerProduct = new Product(new ProductFactoryImpl());
    }
}
