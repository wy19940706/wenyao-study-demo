package com.wenyao.studydemo.annotation;

import java.math.BigDecimal;

/**
 * Created by Think on 2019/2/18
 */
public class User {
    private String name;
    private String age;
    private BigDecimal money;

    @Check
    public String getName() {
        return name;
    }

    @Init(value = "wenyao")
    public void setName(String name) {
        this.name = name;
    }

    @Check
    public String getAge() {
        return age;
    }

    @Init(value = "24")
    public void setAge(String age) {
        this.age = age;
    }

    public BigDecimal getMoney() {
        return money;
    }

    @BigDecimalFormat(decimalDigit = 2)
    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
