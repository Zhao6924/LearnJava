package com.zlx.talk;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPclient2 {
    public static void main(String[] args) throws IOException {
        InetAddress serverIP = InetAddress.getByName("127.0.0.1");
        int port = 9999;
        //创建socket
        Socket socket = null;
        socket = new Socket(serverIP, port);
        OutputStream OS = socket.getOutputStream();
        try {

            OS.write("你好呀，线程池".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (OS!=null)
                OS.close();
            if (socket!=null)
                socket.close();

        }
    }
}