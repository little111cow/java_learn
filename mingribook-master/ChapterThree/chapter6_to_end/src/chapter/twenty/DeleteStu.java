package chapter.twenty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteStu {
	static Connection con;
	static PreparedStatement sql;
	static ResultSet res;
	
	public Connection getConnection() { 

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:"
					+ "//127.0.0.1:3306/test", "root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteStu c = new DeleteStu();
		con = c.getConnection();
		try {
			sql = con.prepareStatement("delete from tb_stu where birthday < ?");
			sql.setString(1, "2010-01-01");
			sql.executeUpdate();
			System.out.println("????ɾ??????");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
