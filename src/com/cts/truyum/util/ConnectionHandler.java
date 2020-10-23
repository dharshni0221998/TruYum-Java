package com.cts.truyum.util;
import java.sql.*;

public class ConnectionHandler {
	
	public static Connection getConnection(){
		Connection con =null;
		String url="jdbc:mysql://localhost:3306/lch_marketplace";
		String user="cts877962";
		String password="cts877962";
		try {
			con=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}

}
