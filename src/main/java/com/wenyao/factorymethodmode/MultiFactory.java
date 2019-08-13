package com.wenyao.factorymethodmode;

/**
 * Created by Think on 2019/4/26
 */
public class MultiFactory implements Factory {
    @Override
    public Operation createOperation() {
        return new MultiOperation();
    }
}
