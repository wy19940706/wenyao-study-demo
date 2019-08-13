package com.wenyao.factorymethodmode;

/**
 * Created by Think on 2019/4/26
 */
public class AddOperation extends Operation {
    @Override
    public double getResult() {
        return super.getNumA() + super.getNumB();
    }
}
