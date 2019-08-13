package com.wenyao.strategymode;

/**
 * Created by Think on 2019/1/3
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doStrategy() {
        this.strategy.test();
    }
}
