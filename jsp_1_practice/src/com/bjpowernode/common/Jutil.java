package com.bjpowernode.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Jutil {
	private static String user;
	private static String password;
	private static String url;
	private static String classname;
	static{
		Properties pro = new Properties();
		InputStream in = Jutil.class.getClassLoader().getResourceAsStream("resource.properties");
		try {
			pro.load(in);
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			url = pro.getProperty("url");
			classname = pro.getProperty("classname");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		
	}
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(classname);
		return DriverManager.getConnection(url, user, password);
	}
	public static void closer(Connection conn,PreparedStatement ps,ResultSet res) {
		if(res != null){
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
