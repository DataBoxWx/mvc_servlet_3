package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.common.Jutil;

public class Myservlet2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入servlet2");
		PrintWriter out = response.getWriter();
	
		String username = request.getParameter("username");		
		System.out.println(username);
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res =null;
		String sql ="select count(*) from tbl_user where username=?";
		Boolean  flag = true;
		try {
			conn = 	Jutil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			res = ps.executeQuery();
			if(res.next()){
				int i = res.getInt(1);
				if(i != 0){
					flag = false;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Jutil.close1(conn, ps, res);
		}
		String b = "fail";
		if(flag){
			b = "success";
			System.out.println(b);
		}
		out.print(b);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
