package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

	
public static Connection getConnect() {
		
		Connection con = null;
		
		final String driver = "com.mysql.cj.jdbc.Driver";
		final String url = "jdbc:mysql://localhost:3306/demo";
		final String username = "root";
		final String password = "aditi@1998";
		
		
		try {
			
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return con;
	}
}
