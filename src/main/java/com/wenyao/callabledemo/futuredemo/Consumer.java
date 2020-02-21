package com.wenyao.callabledemo.futuredemo;

public class Consumer {

    public static void returnProcess(CallbackInterface callbackInterface) {
        int future = callbackInterface.future(1);
        System.out.println(future);
    }
}
