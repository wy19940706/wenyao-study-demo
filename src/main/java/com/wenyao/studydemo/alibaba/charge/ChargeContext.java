package com.wenyao.studydemo.alibaba.charge;

import java.math.BigDecimal;

/**
 * 收费上下文类
 */
public class ChargeContext {

    private ChargePlan chargePlan;

    public ChargeContext(ChargePlan chargePlan) {
        this.chargePlan = chargePlan;
    }

    public BigDecimal charge() {
        return chargePlan.charge();
    }

}
