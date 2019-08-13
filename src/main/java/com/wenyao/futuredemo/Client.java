package com.wenyao.futuredemo;

/**
 * 客户端
 */
public class Client {
    /**
     * 发出请求
     * 
     * @param param
     * @return
     */
    public Data sendRequest(String param) {
        // 立即返回FutureData
        FutureData futureData = new FutureData();
        // 新开一个线程异步获取数据
        new Thread(() -> {
            RealData realData = new RealData(param);
            futureData.setRealData(realData);
        }).start();
        return futureData;
    }
}
