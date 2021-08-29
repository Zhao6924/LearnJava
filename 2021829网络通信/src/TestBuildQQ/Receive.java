package TestBuildQQ;

import javax.sound.sampled.Port;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;

public class Receive extends Thread{
    String thisIp;
    DatagramSocket socket;
    DatagramPacket packet;
    String name;
    int port;
    public Receive(String thisIp, int port){
        this.thisIp= thisIp;
        this.port=port;
        this.name=thisIp;
        try {
            socket=new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while(true){
            byte [] bytes=new byte[10];
            packet=new DatagramPacket(bytes,0,10);
            try {

                socket.receive(packet);
                bytes=packet.getData();
                String data=new String(bytes,0,bytes.length);
                System.out.println(this.name+"说"+data);
                if (data.equals("goodbye"))
                    break;


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        socket.close();

    }

}
