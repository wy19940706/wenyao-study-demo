package com.wenyao.aop.aopexception;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AopInvocationHandler implements InvocationHandler {

    private Object target;

    public AopInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 如果此处不做try-catch并重新抛出target exception,则外界调用方无法catch住原始target异常
        try {
            return method.invoke(target, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }
}
