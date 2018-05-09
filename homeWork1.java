package homeWork1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class homeWork1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/homeWork";
		String user = "root";	
		String passwork = "199729";
		String sql = "select * from staff_static_info where staff_no = '100001'";
		try{
			Connection con = (Connection) DriverManager.getConnection(url , user , passwork ) ;
			System.out.println("鏈接成功");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString("staff_name"));
			}
		}catch(SQLException se){
			System.out.println("数据库连接失败！");
			se.printStackTrace() ;

			}
	}
}
