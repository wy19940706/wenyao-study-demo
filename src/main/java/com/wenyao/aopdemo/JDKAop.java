package com.wenyao.aopdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Think on 2019/3/18
 */
public class JDKAop implements InvocationHandler {

    private Object target;

    public JDKAop(Class clazz) {
        try {
            this.target = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("before method");
    }

    private void after() {
        System.out.println("after method");
    }
}
