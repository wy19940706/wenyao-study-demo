package com.wenyao.studydemo.annotation;

import java.lang.reflect.Field;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import cn.hutool.core.util.NumberUtil;

@Aspect
@Component
public class BigDecimalFormatAspect {

    @Pointcut("@annotation(com.wenyao.studydemo.annotation.BigDecimalFormat)")
    public void bigDecimalFormat() {

    }

    @Pointcut("execution(public * com.wenyao.studydemo.annotation.*.*(..))")
    public void log() {

    }

    @Before("log()")
    public void before(JoinPoint joinPoint) {
        System.out.println("this is a log before");
    }

    @After("log()")
    public void after(JoinPoint joinPoint) {
        System.out.println("this is a log after");
    }

    /**
     * around
     */
    @Around("bigDecimalFormat()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        Object target = joinPoint.getTarget();

        Field[] fields = joinPoint.getArgs().getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(BigDecimalFormat.class)) {
                BigDecimalFormat bigDecimalFormat = field.getAnnotation(BigDecimalFormat.class);
                doBigDecimalFormat(target, field, bigDecimalFormat.decimalDigit());
            }
        }
        return joinPoint.proceed();
    }

    private void doBigDecimalFormat(Object target, Field field, int decimalDigit) {
        try {
            field.set(target, NumberUtil.round(field.getDouble(target), decimalDigit));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
