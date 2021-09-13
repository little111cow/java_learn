package comm;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
/**
 * 用tcp实现网络文件下载（服务器向客户端发送文件）
 * */
public class tcp_application_service implements Runnable {
    private String url_s;
    private BufferedInputStream buffin;
    private OutputStream buffos;

    public tcp_application_service(String url_s){
        this.url_s = url_s;
    }
    public void run(){
        try {
            ServerSocket serversocket = new ServerSocket(9898);
            Socket socket = serversocket.accept();
            buffin = new BufferedInputStream((new FileInputStream(url_s)));
            buffos=socket.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while((len=buffin.read(buffer,0,buffer.length))!=-1){
               buffos.write(buffer,0,len);
            }
            socket.shutdownOutput();
            System.out.println("文件下传成功！");
            buffos.close();
            buffin.close();
            socket.close();
            serversocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        tcp_application_service tcp_app = new tcp_application_service("E:\\Java_learn\\hello.txt");
        Thread t1 = new Thread(tcp_app);
//        Thread t2 = new Thread(tcp_app);
        t1.start();
//        t2.start();
    }
}
