package comm.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

@SuppressWarnings("all")
public class test_jdbc_delete {
    public static void main(String[] args) throws Exception{
        PreparedStatement preparedStatement = null;

        Connection con = test_jdbc_tool.getConnection();
        String sql = "delete from t_mytest where id=?";
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,2020200345);
        int i = preparedStatement.executeUpdate();  //返回更新几条数据
        if(i>0){
            System.out.println("删除成功！");
        }
        test_jdbc_tool.release(con,preparedStatement,null);
    }
}
