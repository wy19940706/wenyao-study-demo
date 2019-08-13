package com.wenyao.reflectdemo;

public class InterfaceFieldTestImpl implements InterfaceFieldTest {

    @Override
    public Integer printMsg(Integer num) {
        return num++;
    }
}
