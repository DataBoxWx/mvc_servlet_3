package com.bjpowernode.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

public class DBUtil {

	// 创建properties属性文件对象
	private static Properties prop = new Properties();

	// 声明数据库连接池对象
	private static DruidDataSource dds = null;

	private DBUtil() {
	}

	static {

		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db_server.properties"));
			dds = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static ThreadLocal<Connection> t = new ThreadLocal<Connection>();

	/*
	 * getConn: 创建一根连接返回/从t中取得连接返回
	 * 
	 * 什么情况下是创建一根连接返回:service层调用getConn方法的时候 什么情况下是直接返回t中的conn:dao层调用的时候
	 * 
	 */
	public static Connection getConn() throws SQLException {

		Connection conn = t.get();

		if (conn == null) {
			//conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//从数据库连接池中来取连接
			conn = dds.getConnection();
			
			t.set(conn);
		}

		return conn;

	}
	
	// 关闭资源
	public static void myClose(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {

		// 关闭的顺序为 按照创建的顺序逆序关闭

		if (rs != null) {
			rs.close();
		}

		if (ps != null) {
			ps.close();
		}

		if (conn != null) {
			conn.close();
			// 很容易忘
			t.remove();
		}

	}

}
