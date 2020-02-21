package com.wenyao.gc;

/**
 * YoungGC run demo
 */
public class YoungGcDemo {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024 * 1024];
        bytes = new byte[1024 * 1024];
        bytes = new byte[1024 * 1024];
        bytes = null;
        byte[] bytes2 = new byte[2 * 1024 * 1024];
    }
}
