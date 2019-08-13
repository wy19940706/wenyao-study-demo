package com.wenyao.concurrentdemo;

import sun.plugin2.jvm.ProcessLauncher;

/**
 * Created by Think on 2019/5/17
 */
public abstract class Animal extends Thread {

    public Integer length = 2000;//比赛长度

    protected abstract void running();

    @Override
    public void run() {
        super.run();
        while (length > 0) {
            running();
        }
    }
}
