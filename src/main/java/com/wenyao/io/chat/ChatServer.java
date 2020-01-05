package com.wenyao.io.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import com.google.common.collect.Maps;

/**
 * 使用nio进行简单群聊功能实现
 */
public class ChatServer {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            // 阻塞在selector上
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 如果是accept事件
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel1.accept();
                    System.out.println("accept new connection:" + socketChannel.getRemoteAddress());
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    ChatHolder.join(socketChannel);
                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    // 将数据读取到buffer中
                    int length = socketChannel.read(buffer);
                    if (length > 0) {
                        buffer.flip();
                        byte[] bytes = new byte[buffer.remaining()];
                        // 将数据读入到bytes数组中
                        buffer.get(bytes);
                        String content = new String(bytes, "UTF-8").replace("\r\n", "");
                        if (content.equalsIgnoreCase("quit")) {
                            ChatHolder.quit(socketChannel);
                            selectionKey.cancel();
                            socketChannel.close();
                        } else {
                            ChatHolder.propagate(socketChannel, content);
                        }
                    }
                }
                iterator.remove();
            }
        }
    }

    private static class ChatHolder {
        static final Map<SocketChannel, String> USER_MAP = Maps.newConcurrentMap();

        /**
         * 加入群聊
         * 
         * @param socketChannel
         */
        static void join(SocketChannel socketChannel) {
            String userId = "用户" + ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
            send(socketChannel, "您的id为：" + userId + "\n\t");
            for (SocketChannel channel : USER_MAP.keySet()) {
                send(channel, userId + "加入了群聊" + "\n\r");
            }
            USER_MAP.put(socketChannel, userId);
        }

        /**
         * 退出群聊
         * 
         * @param socketChannel
         */
        static void quit(SocketChannel socketChannel) {
            String userId = USER_MAP.get(socketChannel);
            send(socketChannel, "您退出了群聊" + "\n\r");
            USER_MAP.remove(socketChannel);
            for (SocketChannel channel : USER_MAP.keySet()) {
                send(channel, userId + "退出了群聊" + "\n\r");
            }
        }

        /**
         * 扩散说话的内容
         */
        public static void propagate(SocketChannel socketChannel, String content) {
            String userId = USER_MAP.get(socketChannel);
            for (SocketChannel channel : USER_MAP.keySet()) {
                if (channel != socketChannel) {
                    send(channel, userId + ":" + content + "\n\r");
                }
            }
        }

        /**
         * 发送消息
         * 
         * @param socketChannel
         * @param message
         */
        private static void send(SocketChannel socketChannel, String message) {
            try {
                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                writeBuffer.put(message.getBytes());
                writeBuffer.flip();
                socketChannel.write(writeBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
