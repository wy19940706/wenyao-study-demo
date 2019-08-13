package com.wenyao.facademode;

/**
 * Created by Think on 2019/1/3
 */
public class Facade {
    private SystemA systemA;
    private SystemB systemB;
    private SystemC systemC;

    public Facade() {
        this.systemA = new SystemA();
        this.systemB = new SystemB();
        this.systemC = new SystemC();
    }

    public void test() {
        systemA.test();
        systemB.test();
        systemC.test();
    }
}
