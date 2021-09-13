import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class test_tcp_client {
    public static void main(String[] args) {
        sendmessage();
    }

    public static void sendmessage() {
        Socket socket_client;
        BufferedOutputStream bw;
        String message = "";
        Scanner input;
        while (true) {
            try {
                socket_client = new Socket("127.0.0.1", 8799);
                bw = new BufferedOutputStream((socket_client.getOutputStream()));
//                System.out.println("完成连接！");
                System.out.println("输入消息：");
                input = new Scanner(System.in);
                message = input.nextLine();
                bw.write(message.getBytes());
                bw.flush();  //必须清空缓冲区
                bw.close();  //需要关闭流

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
