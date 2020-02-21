package com.wenyao.chainmode;

/**
 * 责任链模式的核心其实就是用一个工厂去拿处理链的引用放到集合中，然后在该工厂中循环去遍历处理链的方法进行调用
 */
public class Client {
    public static void main(String[] args) {
        String msg = "消息";
        ChainFactory chainFactory = new ChainFactory().addChain(new HandlerOne()).addChain(new HandlerTwo());
        chainFactory.process(msg);
    }
}
