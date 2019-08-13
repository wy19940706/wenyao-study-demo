package com.wenyao.aopdemo;

import java.lang.reflect.Proxy;

/**
 * Created by Think on 2019/3/18
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = (Subject) Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{Subject.class}, new JDKAop(SubjectImpl.class));
        subject.excute();
    }
}
