package com.wenyao.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;

import lombok.SneakyThrows;

/**
 * aio java server
 */
public class AioServer {
    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        // 监听accept事件
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @SneakyThrows
            @Override
            public void completed(AsynchronousSocketChannel socketChannel, Object attachment) {
                System.out.println("accept new connection:" + socketChannel.getRemoteAddress());
                // 再次监听accept
                serverSocketChannel.accept(null, this);
                // 消息处理
                while (true) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    // 将数据读入到buffer
                    Future<Integer> future = socketChannel.read(buffer);
                    if (future.get() > 0) {
                        buffer.flip();
                        byte[] bytes = new byte[buffer.remaining()];
                        // 将buffer的数据读入到bytes数组中
                        buffer.get(bytes);
                        String content = new String(bytes, "UTF-8");
                        if (content.equals("\r\n")) {
                            continue;
                        }
                        if (content.equalsIgnoreCase("quit")) {
                            socketChannel.close();
                            break;
                        } else {
                            System.out.println("receive message:" + content);
                        }
                    }
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("failed");
            }
        });
        // 阻塞住主线程
        System.in.read();
    }

}
