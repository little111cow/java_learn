package comm.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class test_udp_client {
    public static void main(String[] args) {
        try {
            DatagramSocket socket =new DatagramSocket(9999);
            byte[] buff = new byte[1024];
            while(true) {
                DatagramPacket packet = new DatagramPacket(buff, 0, buff.length);
                socket.receive(packet);
                System.out.println(new String(packet.getData(), 0, packet.getLength()));
                if((new String(packet.getData(),0,packet.getLength())).equals("quit")) {
                    break;
                }
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
