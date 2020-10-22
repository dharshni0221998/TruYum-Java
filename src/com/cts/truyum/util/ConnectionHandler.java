package com.cts.truyum.util;
import java.sql.*;

public class ConnectionHandler {
	
	public static Connection getConnection(){
		Connection con =null;
		try {
			Class.forName("com.mysql.cj.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/lch_marketplace";
		String user="root";
		String password="Rdd@0221998";
		try {
			con=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}

}
