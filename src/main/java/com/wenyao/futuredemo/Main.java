package com.wenyao.futuredemo;

public class Main {
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.sendRequest("Hello Future");
        System.out.println("请求完毕！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("真实数据为:" + data.getResult());
    }
}
