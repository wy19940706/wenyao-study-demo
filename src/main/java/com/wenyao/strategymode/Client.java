package com.wenyao.strategymode;

/**
 * Created by Think on 2019/1/3
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context(StrategyFactory.createStrategy("+"));
        context.doStrategy();
        Context context1 = new Context(StrategyFactory.createStrategy("-"));
        context1.doStrategy();
    }
}
