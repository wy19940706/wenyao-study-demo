package com.wenyao.mybatismapper;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class MapperProxy implements InvocationHandler {

    public <T> T newInstance(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] {clazz}, this::invoke);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (Object.class.equals(method.getDeclaringClass())) {
            try {
                method.invoke(this, args);
            } catch (Throwable throwable) {
                log.error(String.valueOf(throwable.getCause()),throwable);
            }

        }

        return new User((Long) args[0], "wenyao", 24);
    }
}
