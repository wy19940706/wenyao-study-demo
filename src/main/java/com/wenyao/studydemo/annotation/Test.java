package com.wenyao.studydemo.annotation;

/**
 * Created by Think on 2019/2/18
 */
public class Test {
    public static void main(String[] args) {
        User user = UserFactory.create();
        CheckInterceptor checkInterceptor = new CheckInterceptor(user);
        checkInterceptor.check();
        System.out.println(user.getName());
        System.out.println(user.getAge());
    }
}
