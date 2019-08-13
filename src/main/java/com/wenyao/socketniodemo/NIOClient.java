package com.wenyao.socketniodemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Think on 2019/3/11
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream outputStream = socket.getOutputStream();
        String s = "hello world";
        outputStream.write(s.getBytes());
        outputStream.close();
    }
}
