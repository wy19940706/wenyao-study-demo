package com.wenyao.callabledemo;

public class CallableTwoTest {
    public static void main(String[] args) {
        getCallable().callable(5);
    }

    private static CallableInterface getCallable() {
        return new CallableInterface() {
            @Override
            public void callable(int param) {
                System.out.println(param);
            }
        };
    }
}
