package com.wenyao.wenyaostudydemo;

import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;

public class ObjAopTest {
    public static void main(String[] args) {
        Objenesis objenesis = new ObjenesisStd();
        ObjTest objTest = objenesis.newInstance(ObjTest.class);
        System.out.println(objTest.id);
        // System.out.println(ObjTest.class.newInstance());
    }

    class ObjTest {
        Long id = 10L;
    }

}
