package comm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class tcp_application_client {
public static void main(String[] args) {
    try {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9898);
        InputStream is=socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("1.txt"));
        byte[] buff = new byte[1024];
        int len;
        while((len=is.read(buff))!=-1){
            fos.write(buff,0,len);
        }
        socket.shutdownInput();
        System.out.println("文件下载成功！");
        fos.close();
        is.close();
        socket.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}


}
