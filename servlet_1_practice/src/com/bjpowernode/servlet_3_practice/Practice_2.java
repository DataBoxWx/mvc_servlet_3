package com.bjpowernode.servlet_3_practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjpowernode.common.util.Jutilcom;

public class Practice_2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select * from emp ";
		try {
			conn = Jutilcom.getConnection();
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery();
			while(res.next()){
				String emp = res.getString(1);
				System.out.println(emp);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Jutilcom.close2(conn, ps, res);
		}
		
	}
}
