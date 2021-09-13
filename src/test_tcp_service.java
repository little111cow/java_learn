import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class test_tcp_service {
    private Socket service_socket;
    private BufferedInputStream br;
    private ServerSocket ss;
    Scanner input;
    public static void main(String[] args) {
        InetAddress ip;
        try{
            //获取本机ip地址和主机名
            ip = InetAddress.getLocalHost();  //返回本机的InetAddress对象
            String name = ip.getHostName();
            String ipaddress = ip.getHostAddress();
            System.out.println("本机名为："+name);
            System.out.println("本机ip地址为："+ipaddress);

//            InetAddress ip_s = InetAddress.getByName("www.baidu.com");  //通过名称获取百度的主机名和ip地址
//            String name_s = ip_s.getHostName();
//            String ip_s_address = ip_s.getHostAddress();
//            System.out.println("百度本机名为："+name_s);
//            System.out.println("百度ip地址为："+ip_s_address);

        }catch (UnknownHostException e){
            e.printStackTrace();
        }
        new test_tcp_service().getserver();
    }

    public  void getserver() {
        try {
            ss = new ServerSocket(8799);
            System.out.println("创建服务套接字成功等待连接！");
            while (true) {
                service_socket = ss.accept();
                br = new BufferedInputStream(service_socket.getInputStream());
                rcv();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public void rcv() {
        int len=1024;
        byte[] mes=new byte[len];
            try {
                while ( br.read(mes,0,len) != -1) {
                    for(byte c:mes) {
                        System.out.print((char)c);
                    }
                    System.out.println();
                }
                service_socket.close();
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }

}
