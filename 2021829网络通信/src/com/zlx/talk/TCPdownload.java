package com.zlx.talk;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPdownload {
    public static void main(String[] args)  throws Exception{
        //1.创建服务
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.监听客户端连接
        Socket accept = serverSocket.accept();
        //3.获取输入流
        InputStream is = accept.getInputStream();

        //4.文件输出
        FileOutputStream fos = new FileOutputStream(new File("receive.jpg"));//接收文件就要用文件的管道流
        byte[] buff = new byte[1024];
        int len;
        while ((len = is.read(buff)) != -1){
            fos.write(buff,0,len);
        }


        //通过客户端我接收完毕了
        OutputStream os = accept.getOutputStream();
        os.write("我接收完毕了，你可以断开了".getBytes());

        fos.close();
        is.close();
        accept.close();
        serverSocket.close();

    }
}
