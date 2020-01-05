package com.wenyao.aop;

public class Test {
    public static void main(String[] args) {
        Target jdkProxy = JdkDynamicAop.newProxyInstance(new TargetImpl());
        jdkProxy.jdkTest();

        Target cglibProxy = CglibDynamicAop.newProxyInstance(TargetImpl.class);
        cglibProxy.cgliTest();
    }
}
