import java.io.*;

public class test_io {
    public static void main(String[] args){
        File file=new File("E:\\Java_learn\\hello.txt");  //实列化一个文件对象
        if(file.exists()){  //判断文件是否存在
            file.delete();  //存在就删除文件  //返回boolean值
            System.out.println("文件已删除！");
        }else {
            try {
                file.createNewFile();  //创建新的文件,返回boolean值
                System.out.println("文件已创建！");
            } catch (IOException e) {
                e.printStackTrace();
            }
            String filepath = file.getAbsolutePath();  //获取文件的绝对路径
//        System.out.println(filepath);
//        file.delete();  //删除文件
            System.out.println(file.getParent());  //获取其父目录
            System.out.println(file.length());  //获取文件长度，单位是字节
            System.out.println(file.lastModified());  //获得最后修改时间

            try {
                FileOutputStream fos = new FileOutputStream(file);  //创建文件输入流对象实现文件的写,此类只提供对字节和字节流的操作
                byte[] s="这是文件读写的简单实列！".getBytes();  //转换为字节流，getBytes（）方法的运用
                fos.write(s);
                fos.write("\n".getBytes());  //写入换行符
                fos.write(s);  //再次写入s
                fos.close();  //关闭流，养成好习惯
            }catch (IOException e){
                e.printStackTrace();
            }

            try {
                FileInputStream fis = new FileInputStream(file);  //创建文件输入流对象实现文件的读,此类只提供对字节和字节流的操作
                byte[] rdbyte=new byte[(int)file.length()];  //根据文件长度创建存储字节数组
                int len=fis.read(rdbyte);  //读取放在数组中，返回长度
                System.out.println(len);
                System.out.println("文件中的信息为：\n"+new String(rdbyte,0,len));  //转为字符串输出
                fis.close();  //关闭流，养成好习惯
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        use_filereader_writer mytool=new use_filereader_writer();
        mytool.write(file);
        mytool.read(file);
        mytool.writewithbuff(file);
        mytool.readwithbuff(file);
    }
}
class use_filereader_writer{
        public void write(File file){
            try {
                FileWriter fw=new FileWriter(file);  //创建写入字符流对象
                String s="写入文件的字符流！";
                fw.write(s);  //将字符串写入文件对象
                System.out.println("写入成功！");
                fw.close();  //关闭流
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        public void read(File file){
            try {
                FileReader fr=new FileReader(file);  //文件读取流对象
                char[] rd=new char[(int)file.length()];  //存储读入字符的字符数组
                int len=fr.read(rd);  //读取存入数组，并返回长度
                System.out.println("读出的内容为："+new String(rd,0,len));  //转换为字符串输出
                fr.close();  //关闭流
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        public void writewithbuff(File file){  //带缓冲的文件读写
            try {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw= new BufferedWriter(fw);
                String[] s= new String[]{"第一行","第二行","第三行"};
                for(String str:s) {
                    bw.write(str);
                    bw.newLine();  //换行
                }
                bw.flush();  //关闭之前最好要刷新缓冲区将数据写出，否则可能报错
                bw.close();  //关闭流，会自动调用flush方法
                System.out.println("写入成功！");
                fw.close();  //关闭流
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        public void readwithbuff(File file){
            try{
                FileReader fr= new FileReader(file);
                BufferedReader br=new BufferedReader(fr);  //带缓冲的字符输出流对象
                String s=null;
                int i=0;
                while((s=br.readLine())!=null){
                    i++;
                    System.out.println("第"+i+"行："+s);
                }
                fr.close();
                br.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        }