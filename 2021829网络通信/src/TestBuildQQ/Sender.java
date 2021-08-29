package TestBuildQQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Sender extends Thread{
    DatagramSocket socketPort;
    DatagramPacket packet;
    String data;
    String PointIp;
    String thisIp;
    String name;
    int toPort;
    int thisport;
    public Sender(String pointIp,int toPort,String thisIp,String name,int thisport){
        this.PointIp=pointIp;
        this.toPort=toPort;
        this.thisIp=thisIp;
        this.name=name;
        this.thisport=thisport;
    }
    @Override
    public void run() {
        byte [] bytes;
        try {
            socketPort=new DatagramSocket(this.thisport);

        } catch (SocketException e) {
            e.printStackTrace();
        }
        while(true){
            try {
                BufferedReader  reader=new BufferedReader(new InputStreamReader(System.in));
                data=reader.readLine();
                bytes=data.getBytes(StandardCharsets.UTF_8);
                packet=new DatagramPacket(bytes,bytes.length,new InetSocketAddress(this.PointIp,this.toPort));
                if (data.equals("goodbye"))
                    break;
                socketPort.send(packet);
                System.out.println(name+"说"+data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }  socketPort.close();
    }
}
