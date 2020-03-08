package com.wenyao.aop.aopexception;

import java.lang.reflect.Proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    public static void main(String[] args) {
        FooService proxyInstance = (FooService) Proxy.newProxyInstance(FooService.class.getClassLoader(),
                new Class[] {FooService.class}, new AopInvocationHandler(new FooServiceImpl()));

        try {
            proxyInstance.uncheckedException();
        } catch (RuntimeException e) {
            // 代码能进入到此处
            log.error(e.getMessage(), e);
        }
        try {
            proxyInstance.checkedException();
        } catch (IllegalAccessException e) {
            // 代理类如果不做catch重新抛出target exception,代码不能进入到此处
            log.error(e.getMessage(), e);
        }
    }
}
