package com.zlx.talk;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class TCPuoload {

    public static void main(String[] args) throws Exception {
        //1.建立连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
        //2.创建一个输出流
        OutputStream os = socket.getOutputStream();
        //3.读取文件
        FileInputStream is = new FileInputStream(new File("1.jpg"));
        byte[] buff = new byte[1024];
        int len;
        //4.写出文件
        while ((len = is.read(buff)) != -1) {
            os.write(buff, 0, len);
        }

        //通知服务器，我已经结束了
        socket.shutdownOutput();//我已经传输完了的意思

        //确定服务器接收完毕，才能够断开连接
        InputStream inputStream = socket.getInputStream();//接收字符、就用字节的管道流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buff2 = new byte[1024];
        int len2;
        while ((len2 = inputStream.read(buff)) != -1) {
            bos.write(buff2, 0, len2);
        }
        System.out.println(bos.toString());


        //5.释放资源
        bos.close();
        inputStream.close();
        is.close();
        os.close();
        socket.close();

    }

}