package com.wenyao.studydemo.annotation;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

/**
 * Created by Think on 2019/2/18
 */
@Service("testService")
public class TestService {
    public void test() {
        // User user = UserFactory.create();
        // CheckInterceptor checkInterceptor = new CheckInterceptor(user);
        // checkInterceptor.check();
        // assert user != null;
        // System.out.println(user.getName());
        // System.out.println(user.getAge());
        // System.out.println(user.getMoney());
        User user = new User();
        user.setMoney(new BigDecimal("1.23345"));
        System.out.println(user.getMoney());
    }
}
