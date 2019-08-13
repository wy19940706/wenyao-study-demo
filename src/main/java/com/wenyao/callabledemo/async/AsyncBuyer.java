package com.wenyao.callabledemo.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsyncBuyer implements OrderResultTwo {

    private static final Logger logger = LoggerFactory.getLogger(AsyncBuyer.class);

    private Store store;
    private String asyncBuyer;
    private String goodsName;

    public AsyncBuyer(Store store, String asyncBuyer, String goodsName) {
        this.store = store;
        this.asyncBuyer = asyncBuyer;
        this.goodsName = goodsName;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getAsyncBuyer() {
        return asyncBuyer;
    }

    public void setAsyncBuyer(String asyncBuyer) {
        this.asyncBuyer = asyncBuyer;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 
     * @return
     */
    public String orderGoods() {
        String goodsState = "--";
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        System.out.println(goodsState);
        goodsState = myRunnable.getResult();
        System.out.println(goodsState);
        return goodsState;
    }

    @Override
    public String getOrderResult(String state) {
        return this.getAsyncBuyer() + "在" + this.getStore().getName() + "商店订购的" + this.getGoodsName() + "玩具, 目前的预订状态是: "
                + state;
    }

    private class MyRunnable implements Runnable {

        private String result;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                result = store.returnOrderGoodsInfo(AsyncBuyer.this);
                System.out.println(result);
            } catch (InterruptedException e) {
                logger.error("异步回调错误", e);
            }
        }
    }
}
