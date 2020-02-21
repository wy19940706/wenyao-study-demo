package com.wenyao.callabledemo.futuredemo;

public class Provider {
    public static void main(String[] args) {
        Consumer.returnProcess(new CallbackInterface() {
            @Override
            public int future(int param) {
                return param + 1;
            }
        });
    }
}
