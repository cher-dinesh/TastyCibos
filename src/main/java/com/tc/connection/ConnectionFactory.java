package com.tc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
	static private Connection con=null;
	static private String url="jdbc:mysql://localhost:3306/hungry_bird";
	static private String un="root";
	static private String pwd="root";

	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,un,pwd);
		return con;
	}

	public static void close(Connection con,PreparedStatement pstm) {
		try {
			if(pstm != null) {
				pstm.close();
			}
			if(con!=null) {
				con.close();
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
