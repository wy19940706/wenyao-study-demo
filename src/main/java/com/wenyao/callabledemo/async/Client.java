package com.wenyao.callabledemo.async;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Store store = new Store("永辉超市");
        AsyncBuyer asyncBuyer = new AsyncBuyer(store, "小明", "手机");
        System.out.println(asyncBuyer.orderGoods());
    }
}
