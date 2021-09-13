package comm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class test_jdbc_insert {
    public static void main(String[] args) {
        String db_driver = "com.mysql.jdbc.Driver";
        String db_url = "jdbc:mysql://localhost:3306/xboot?useUnicode=true&characterset=utf8&useSSL=true";
        String user = "root";
        String psw = "root";
        Connection con = null;
        PreparedStatement statement = null;
        System.out.println("连接数据库...");
        try {
            con = DriverManager.getConnection(db_url,user,psw);
            System.out.println("连接成功！");
            String sql = "insert into t_mytest(id,`name`,sex,school) values(?,?,?,?)";
            statement = con.prepareStatement(sql);
            statement.setBytes(1,"2020200345".getBytes());
            statement.setBytes(2,"小明".getBytes());
            statement.setBytes(3,"男".getBytes());
            statement.setBytes(4,"计算机学院".getBytes());
            int r = statement.executeUpdate();
            if(r>0) {
                System.out.println("插入成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("连接失败！");
        }finally {
            try{
                if(statement!=null){
                    statement.close();
                }
                if(con!=null){
                    con.close();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
