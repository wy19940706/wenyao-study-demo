package com.wenyao.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;


/**
 * 文件channel测试类
 */
public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        // 从文件获取一个channel
        FileChannel fileChannel = new RandomAccessFile("/Users/wenyao/dubbo-resolve.properties", "rw").getChannel();
        // 声明一个byte类型的buffer
        ByteBuffer buffer = ByteBuffer.allocate(10);
        while (fileChannel.read(buffer) != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                int remaining = buffer.remaining();
                byte[] bytes = new byte[remaining];
                buffer.get(bytes);
                System.out.println(new String(bytes, StandardCharsets.UTF_8));
            }
            buffer.clear();
        }
    }
}
