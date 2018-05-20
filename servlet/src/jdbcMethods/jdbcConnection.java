package jdbcMethods;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class jdbcConnection {
	
	
	public Connection con;
	/**
	 * 连接数据库
	 * @throws ClassNotFoundException
	 */
	public void connection() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/homeWork";
		String user = "root";	
		String paswork = "199729";
		try {
			con = (Connection) DriverManager.getConnection(url, user, paswork);
			System.out.println("连接成功");
		} catch (Exception e) {
			System.out.println("数据库连接失败！");
		}
	}
	
	public void insert(String userName,String passwork) throws SQLException{
		String sql = "insert into user(user,passwork)  values (" +userName+","+passwork+")";
		System.out.println(sql);
		Statement stmt = (Statement) con.createStatement();
		boolean rs = stmt.execute(sql);
		if(rs){
			System.out.println("注册成功");
		}else{
			System.out.println("注册失败");
		}
	}
	
}
