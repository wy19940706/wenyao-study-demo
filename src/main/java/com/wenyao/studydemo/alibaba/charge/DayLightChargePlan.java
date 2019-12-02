package com.wenyao.studydemo.alibaba.charge;

import java.math.BigDecimal;

/**
 * 白天收费计划
 */
public class DayLightChargePlan extends AbstractPhoneChargePlan {

    private int callMinutes;

    public DayLightChargePlan(int callMinutes) {
        this.callMinutes = callMinutes;
    }

    @Override
    protected BigDecimal specificCharge() {
        System.out.println("这是白天的收费标准");
        BigDecimal result = BigDecimal.valueOf(0.5);
        if (callMinutes <= 0) {
            return BigDecimal.ZERO;
        }
        if (callMinutes <= 1) {
            return result;
        } else {
            result.add(BigDecimal.valueOf(callMinutes - 1).multiply(BigDecimal.valueOf(0.1)));
        }
        return result;
    }
}
