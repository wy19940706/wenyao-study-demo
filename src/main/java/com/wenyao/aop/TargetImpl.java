package com.wenyao.aop;

public class TargetImpl implements Target {

    @Override
    public void jdkTest() {
        System.out.println("this is jdk aop");
    }

    @Override
    public void cgliTest() {
        System.out.println("this is cglib aop");
    }
}
