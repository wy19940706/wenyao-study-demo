package com.wenyao.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicAop implements InvocationHandler {

    private Target target;

    public JdkDynamicAop(Target target) {
        this.target = target;
    }

    public static Target newProxyInstance(Target target) {
        return (Target) Proxy.newProxyInstance(JdkDynamicAop.class.getClassLoader(), new Class<?>[] {Target.class},
                new JdkDynamicAop(target));
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
