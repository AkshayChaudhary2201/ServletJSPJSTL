package com.acc.utility;
import java.sql.*;

public class dbconnection{
	public static Connection con;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp", "root", "adm@123");

		return con;
				}
}