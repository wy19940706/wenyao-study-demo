package com.wenyao.factorymethodmode;

/**
 * Created by Think on 2019/4/26
 */
public class DivOperation extends Operation {
    @Override
    public double getResult() {
        if (super.getNumB() == 0) {
            throw new IllegalArgumentException("除数不能为0");
        }
        return super.getNumA() / super.getNumB();
    }
}
