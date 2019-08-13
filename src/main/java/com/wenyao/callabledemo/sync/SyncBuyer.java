package com.wenyao.callabledemo.sync;

public class SyncBuyer implements OrderResult {

    private Store store;
    private String buyerName;
    private String goodsName;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 
     * @param store
     * @param buyerName
     * @param goodsName
     */
    public SyncBuyer(Store store, String buyerName, String goodsName) {
        this.store = store;
        this.buyerName = buyerName;
        this.goodsName = goodsName;
    }

    /**
     * 
     * @return
     */
    public String orderGoods() {
        String goodsState = store.returnOrderGoodsInfo(this);
        System.out.println(goodsState);
        return goodsState;
    }

    @Override
    public String getOrderResult(String state) {
        return this.getBuyerName() + "在" + this.store.getName() + "购买的" + this.getGoodsName() + "玩具,目前的状态为" + state;
    }
}
