package comm.udp;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class test_udp_service {
    public static void main(String[] args) {
        try {
            DatagramSocket ds =new DatagramSocket();
            byte[] buff = new byte[1024];
            int len;
            while(true) {
                BufferedInputStream bis = new BufferedInputStream(System.in);
                DatagramPacket packet=null;
                while ((len = bis.read(buff)) != -1) {
                    packet = new DatagramPacket(buff, 0, len, InetAddress.getByName("localhost"), 9999);
                    ds.send(packet);
                }
                bis.close();
                if((new String(packet.getData(),0,packet.getLength())).equals("quit")){
                    break;
                }
            }
            ds.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
