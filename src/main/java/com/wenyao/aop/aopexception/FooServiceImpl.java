package com.wenyao.aop.aopexception;

public class FooServiceImpl implements FooService {

    @Override
    public void uncheckedException() {
        throw new RuntimeException("非受检异常");
    }

    @Override
    public void checkedException() throws IllegalAccessException {
        throw new IllegalAccessException("受检异常");
    }
}
