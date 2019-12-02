package com.wenyao.callabledemo.demo;

public class ClientTest {

    public static void main(String[] args) {
        ConsumerOne consumerOne = new ConsumerOne();
        consumerOne.useServiceResult(5, 2);
    }
}
