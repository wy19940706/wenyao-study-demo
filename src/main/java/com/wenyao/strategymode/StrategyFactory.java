package com.wenyao.strategymode;

/**
 * Created by Think on 2019/4/26
 */
public class StrategyFactory {

    public static Strategy createStrategy(String ope) {
        Strategy strategy = null;
        switch (ope) {
            case "+":
                strategy = new StrategyOne();
                break;
            case "-":
                strategy = new StrategyTwo();
                break;
        }
        return strategy;
    }
}
