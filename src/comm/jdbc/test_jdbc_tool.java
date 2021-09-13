package comm.jdbc;

import java.sql.*;

public class test_jdbc_tool {
    private final static String db_driver = "com.mysql.jdbc.Driver";
    private final static String db_url = "jdbc:mysql://localhost:3306/xboot?useUnicode=true&characterset=utf8&useSSL=true";
    private final static String user = "root";
    private final static String psw = "root";

    public static Connection getConnection() throws ClassNotFoundException,SQLException{
            Class.forName(db_driver);
            System.out.println("连接数据库...");
            Connection con = DriverManager.getConnection(db_url, user, psw);
            System.out.println("连接成功！");
            return con;
    }

    @SuppressWarnings("all")
    public static void release(Connection con,PreparedStatement preparedStatement, ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(con!=null){
                con.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
