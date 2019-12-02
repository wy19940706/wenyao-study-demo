package com.wenyao.studydemo.alibaba.charge;

import java.util.Date;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

/**
 * 电话收费计划工厂类
 */
public class PhoneChargePlanFactory {

    public static ChargePlan createPhoneChargePlan(Date currentTime, int callMinutes) {
        Date dayLightStartTime = DateUtil.parse("07:00:00", DatePattern.NORM_TIME_PATTERN);
        Date dayLightEndTime = DateUtil.parse("19:00:00", DatePattern.NORM_TIME_PATTERN);
        if (isDayLightTimeRange(currentTime, dayLightStartTime, dayLightEndTime)) {
            return new DayLightChargePlan(callMinutes);
        } else {
            return new DarkChargePlan(callMinutes);
        }
    }

    private static boolean isDayLightTimeRange(Date currentTime, Date dayLightStartTime, Date dayLightEndTime) {
        if (currentTime.after(dayLightStartTime) && currentTime.before(dayLightEndTime)) {
            return true;
        }
        return false;
    }
}
