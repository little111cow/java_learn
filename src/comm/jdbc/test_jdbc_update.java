package comm.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class test_jdbc_update {
    public static void main(String[] args) throws Exception {
        PreparedStatement preparedStatement = null;

        Connection con = test_jdbc_tool.getConnection();
        String sql = "UPDATE t_mytest set name=?,sex=? where id=?";
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setBytes(1,"杨翠".getBytes());
        preparedStatement.setBytes(2,"女".getBytes());
        preparedStatement.setInt(3,2020200345);
        int i = preparedStatement.executeUpdate();  //返回更新几条数据
        if(i>0){
            System.out.println("更新成功！");
        }
        test_jdbc_tool.release(con,preparedStatement,null);

    }
}
