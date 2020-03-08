package com.wenyao.aop.aopexception;

public interface FooService {
    void uncheckedException();

    void checkedException() throws IllegalAccessException;
}
