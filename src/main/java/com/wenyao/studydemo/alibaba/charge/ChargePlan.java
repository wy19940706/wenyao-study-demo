package com.wenyao.studydemo.alibaba.charge;

import java.math.BigDecimal;

/**
 * 收费计划
 */
public interface ChargePlan {
    BigDecimal charge();
}
