package comm.url;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**通过URL类
 * HttpURLConnection类
 * 和流下载网络资源*/
public class download_websourse {
    public static void main(String[] args) {
        try {

            //此处下载了网易云的一首歌
            URL url = new URL("https://m701.music.126.net/20210905181121/16a6a8820fe29206456abd19068a004b/jdyyaac/obj/w5rDlsOJwrLDjj7CmsOj/10637301811/67c6/7c28/ec5f/ce3948607cd27578dc830a1f01121ff7.m4a");
//            URL url = new URL("https://upos-hz-mirrorakam.akamaized.net/upgcxcode/20/10/324921020/324921020-1-30280.m4s");
            HttpURLConnection huc=(HttpURLConnection) url.openConnection();  //打开连接
            InputStream ins= huc.getInputStream();  //获得输入流
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("1.m4a"));
            byte[] buffer = new byte[1024];
            int len;
            while((len=ins.read(buffer))!=-1){
                bos.write(buffer,0,len);  //输出流
            }
            bos.close();  //关闭流
            ins.close();  //关闭流
            huc.disconnect();  //关闭连接
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
