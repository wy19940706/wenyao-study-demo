package com.wenyao.studydemo.iodemo;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/**
 * Created by Think on 2019/2/21
 */
public class ByteBufferMethodTest {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(33);
        System.out.println("------------Test reset---------");
        buffer.clear();
        buffer.position(5);
        buffer.mark();
        buffer.position(10);
        System.out.println("before reset:" + buffer);
        buffer.reset();
        System.out.println("after reset:" + buffer);
        System.out.println("-----------Test rewind----------");
        buffer.clear();
        buffer.position(10);
        buffer.limit(15);
        System.out.println("before rewind:" + buffer);
        //position值设为0,mark设为-1,不改变limit的值
        buffer.rewind();
        System.out.println("after rewind:" + buffer);

    }
}
