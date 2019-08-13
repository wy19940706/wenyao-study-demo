package com.wenyao.aopdemo;

import org.springframework.stereotype.Service;

/**
 * Created by Think on 2019/3/18
 */
@Service("subject")
public class SubjectImpl implements Subject {

    @Override
    public void excute() {
        System.out.println("the target object excute");
    }
}
