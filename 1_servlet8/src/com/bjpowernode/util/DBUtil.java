package com.bjpowernode.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	private DBUtil(){}
	
	static{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	//取得连接
	public static Connection getConn() throws SQLException{
		
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		return conn;
		
	}
	
	
	//关闭资源
	public static void myClose(Connection conn,PreparedStatement ps,ResultSet rs) throws SQLException{
		
		//关闭的顺序为 按照创建的顺序逆序关闭
		
		if(rs!=null){
			rs.close();
		}
		
		if(ps!=null){
			ps.close();
		}
		
		if(conn!=null){
			conn.close();
		}
		
	}
	
	
	
}















