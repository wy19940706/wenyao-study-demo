package com.wenyao.callabledemo.async;

public class Store {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Store(String name) {
        this.name = name;
    }

    public String returnOrderGoodsInfo(OrderResultTwo orderResult) {
        return orderResult.getOrderResult("订购中");
    }
}
