package com.zlx;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class TestAddress {
    public static void main(String[] args) throws UnknownHostException {
        //查询IP地址
        try {
            InetAddress address=InetAddress.getByName("www.baidu.com");
            System.out.println(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        //查询本机IP
        InetAddress address=InetAddress.getByName("www.baidu.com");
        System.out.println(address);
        //常用方法
        System.out.println(address.getAddress());
        System.out.println(address.getHostAddress());//ip
        System.out.println(address.getHostName());//域名
        System.out.println(address.getCanonicalHostName());
    }

}
