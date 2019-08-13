package com.wenyao.chainmode;

/**
 * Created by Think on 2019/5/22
 */
public class HandlerOne implements ChainHandler {

    @Override
    public void process(String msg) {
        System.out.println("第一条处理链处理消息：" + msg);
    }
}
