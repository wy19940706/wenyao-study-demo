package com.wenyao.chainmode;

/**
 * Created by Think on 2019/5/22
 */
public class Client {
    public static void main(String[] args) {
        String msg = "消息";
        ChainFactory chainFactory = new ChainFactory().addChain(new HandlerOne()).addChain(new HandlerTwo());
        chainFactory.process(msg);
    }
}
