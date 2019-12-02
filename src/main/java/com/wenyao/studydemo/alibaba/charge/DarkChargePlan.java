package com.wenyao.studydemo.alibaba.charge;

import java.math.BigDecimal;

/**
 * 晚上收费计划
 */
public class DarkChargePlan extends AbstractPhoneChargePlan {

    private int callMinutes;

    public DarkChargePlan(int callMinutes) {
        this.callMinutes = callMinutes;
    }

    @Override
    protected BigDecimal specificCharge() {
        System.out.println("这是晚上的收费标准");
        return calculateCost(callMinutes);
    }

    private BigDecimal calculateCost(int callMinutes) {
        BigDecimal result = BigDecimal.valueOf(0.3);
        if (callMinutes <= 0) {
            return BigDecimal.ZERO;
        }
        if (callMinutes <= 1) {
            return result;
        }
        if (callMinutes <= 11) {
            return result.add(BigDecimal.ONE);
        } else {
            return result.add(BigDecimal.ONE)
                    .add(BigDecimal.valueOf(callMinutes - 11).multiply(BigDecimal.valueOf(0.1)));
        }
    }
}
