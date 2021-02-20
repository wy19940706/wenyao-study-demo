package com.wenyao.studydemo.alibaba.limit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description api限流注解
 * @author wenyao
 * @Date 2021/1/17 下午2:21
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiLimit {

    /**
     * 请求次数
     */
    int maxRequestCount();

    /**
     * 限流时间限制
     */
    long limitTime();

    /**
     * api名称
     */
    String apiName();
}

