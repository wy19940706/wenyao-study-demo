package com.wenyao.callabledemo;

public class CallableTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        doRequest((code, result) -> System.out.println(code + " " + result));
    }

    private static void doRequest(final InterfaceOne callable) {
        callable.doResponse(1, "OK");
    }

    interface InterfaceOne {
        void doResponse(int code, String result);
    }

}
