package com.wenyao.studydemo.alibaba.charge;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        ChargeContext chargeContext = new ChargeContext(PhoneChargePlanFactory.createPhoneChargePlan(new Date(), 6));
        BigDecimal result = chargeContext.charge();
        System.out.println("本次通话收费: " + result);
    }
}
