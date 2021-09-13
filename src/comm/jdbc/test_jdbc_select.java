package comm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class test_jdbc_select {
    //可以把它包装为方法类
    public static void main(String[] args) {
        String DRIVER = "com.mysql.jdbc.Driver";  //加载驱动
        String DB_URL = "jdbc:mysql://localhost:3306/xboot";  //要连接的数据库
        ResultSet res = null;  //结果集
        PreparedStatement statement = null;  //sql执行对象
        Connection con = null;  //数据库对象

        try {
            Class.forName(DRIVER);  //加载驱动
            con = DriverManager.getConnection(DB_URL,"root","root");  //连接到数据库
            String sql = "select * from t_mytest";
            statement = con.prepareStatement(sql);  //声明statement 或者 preparedstatement对象，后者可以预编译实现动态执行sql语句，防止sql注入，具备安全性
            res = statement.executeQuery();  //执行查询语句，更新，插入，删除用executeupdate（）方法
            while(res.next()){
                System.out.print(res.getObject("id")+" ");  //可以用明确告知类型的方法，性能更好
                System.out.print(res.getObject("name")+" ");
                System.out.print(res.getObject("sex")+" ");
                System.out.print(res.getObject("school")+" ");
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {  //finally块关闭资源
            try {
                if(res!=null) {
                    res.close();
                }
                if(statement!=null) {
                    statement.close();
                }
                if(con!=null) {
                    con.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
