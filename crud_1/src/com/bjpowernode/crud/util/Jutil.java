package com.bjpowernode.crud.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class Jutil {
	private static Properties pro = new Properties();
	private static DruidDataSource dds = null;
	private Jutil(){
		
	}
	static{
		try {
			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db_server.properties"));
			dds = (DruidDataSource) DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static ThreadLocal<Connection> t = new ThreadLocal<>();
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection conn =t.get();
		if(conn==null){
			conn=dds.getConnection();
			t.set(conn);
		}
		return conn;
	}
	public static void close1(Connection conn,PreparedStatement ps, ResultSet res) {
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
		if( conn!= null){
			try {
				conn.close();
				t.remove();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
