package com.bjpowernode.servlet_1_practice;

import java.sql.*;

public class Jdbc_Practice1 {
	private static void test() {
		try {
			Driver driver=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			String root = "root";
			String password = "root";
			String url="jdbc:mysql://localhost:3306/bjpowernode";
			Connection connection = DriverManager.getConnection(url, root, password);
			
			Statement statement = connection.createStatement();
			 String str = "select * from emp";
			 
			 ResultSet res = statement.executeQuery(str);
			while(res.next()){
				int num = res.getInt("empno");
				String name = res.getString("ename");
				System.out.println(num + "," + name);
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		test();
	}
}
