package com.wenyao.callabledemo.demo;

public class ConsumerOne implements Callable {

    @Override
    public int service(int a, int b) {
        System.out.println(a);
        System.out.println(b);
        return 0;
    }

    public void useServiceResult(int addResult, int subResult) {
        new Service().getResult(addResult, subResult, this);
    }
}
