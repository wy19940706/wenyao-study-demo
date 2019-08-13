package com.wenyao.factorymethodmode;

/**
 * Created by Think on 2019/4/26
 */
public class Test {
    public static void main(String[] args) {
        Factory addFactory = new AddFactory();
        Operation operation = addFactory.createOperation();
        operation.setNumA(10);
        operation.setNumB(20);
        double result = operation.getResult();
        System.out.println(result);
    }
}
