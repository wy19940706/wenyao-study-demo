package com.wenyao.callabledemo.sync;

public class Client {
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        Store store = new Store("永辉超市");
        SyncBuyer syncBuyer = new SyncBuyer(store, "小明", "洗衣机");
        syncBuyer.orderGoods();
    }
}
