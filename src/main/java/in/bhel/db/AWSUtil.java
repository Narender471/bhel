package in.bhel.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AWSUtil {
	private AWSUtil() {	
	}
	static {
		//step1: loading and register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	public static Connection getJdbcConnection() throws SQLException {
		
		String url = "jdbc:mysql://pssr.cokkmicbyhk2.eu-north-1.rds.amazonaws.com:3306/pssr"; 
		String user = "admin"; 
		String password = "9821426136"; 
		Connection connection = DriverManager.getConnection(url, user, password); 
		System.out.println("connection object created..."); 
		return connection;
		
	}
	public static void cleanUp(Connection con, Statement stmt, ResultSet resultSet) throws SQLException {
		if(con != null) {
			con.close();
			System.out.println("connection object closed");
		}
		if(stmt != null) {
			stmt.close();
		}
		if(resultSet != null) {
			resultSet.close();
		}
		
	
	}

}
