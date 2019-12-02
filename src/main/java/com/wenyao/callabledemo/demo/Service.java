package com.wenyao.callabledemo.demo;

public class Service {

    public void getResult(int a, int b, Callable callable) {
        int addResult = a + b;
        int subResult = a - b;
        callable.service(addResult, subResult);
    }
}
