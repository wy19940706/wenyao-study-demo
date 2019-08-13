package com.wenyao.studydemo.annotation;

import java.lang.reflect.Method;

public class CheckInterceptor {

    private Object target;

    public CheckInterceptor(Object target) {
        this.target = target;
    }

    /**
     * 
     */
    public void check() {
        Method[] methods = target.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)) {
                CheckTest.check();
            }
        }
    }
}
