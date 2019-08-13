package com.wenyao.factorymethodmode;

/**
 * Created by Think on 2019/4/26
 */
public class AddFactory implements Factory {
    @Override
    public Operation createOperation() {
        return new AddOperation();
    }
}
