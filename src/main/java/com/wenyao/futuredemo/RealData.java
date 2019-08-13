package com.wenyao.futuredemo;


public class RealData implements Data {

    private String result;

    /**
     * 
     * @param param
     */
    public RealData(String param) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(param);
        try {
            // 模拟构造真实数据的耗时操作
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result = stringBuffer.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
