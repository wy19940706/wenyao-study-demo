package com.wenyao.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * java bio server
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            System.out.println("start accetp");
            Socket socket = serverSocket.accept();
            System.out.println("new connect:" + socket.getRemoteSocketAddress());
            new Thread(() -> {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String message;
                    while ((message = bufferedReader.readLine()) != null) {
                        if (message.equalsIgnoreCase("quit")) {
                            bufferedReader.close();
                            socket.close();
                            break;
                        } else {
                            System.out.println("receive message:" + message);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
