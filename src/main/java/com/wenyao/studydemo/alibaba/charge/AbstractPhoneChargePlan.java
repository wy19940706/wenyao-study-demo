package com.wenyao.studydemo.alibaba.charge;

import java.math.BigDecimal;

/**
 * 电话收费计划抽象类
 */
public abstract class AbstractPhoneChargePlan implements ChargePlan {

    @Override
    public BigDecimal charge() {
        System.out.println("以下是电话收费");
        return specificCharge();
    }

    protected abstract BigDecimal specificCharge();

}
