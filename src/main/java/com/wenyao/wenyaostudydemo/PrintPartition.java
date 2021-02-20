package com.wenyao.wenyaostudydemo;

import java.util.Date;

import cn.hutool.core.date.DateUtil;

/**
 * @author wenyao
 * @Description 打印分区
 * @Date 2020/7/28 10:40 上午
 */
public class PrintPartition {

    public static void main(String[] args) {
        Date today = DateUtil.date();
        while (true) {
            if (today.before(DateUtil.parse("2023-12-31"))) {
                String format1 = DateUtil.format(DateUtil.beginOfMonth(today), "YYYYMMdd");
                String format = String.format(
                        "ALTER table xianzhi.adnest_site_hour_data add RANGE PARTITION %s00 <=VALUES< %s24;", format1,
                        DateUtil.format(DateUtil.beginOfMonth(DateUtil.offsetMonth(today, 1)), "YYYYMMdd"));
                System.out.println(format);
                today = DateUtil.offsetMonth(today, 1);
            } else {
                break;
            }
        }
    }
}
