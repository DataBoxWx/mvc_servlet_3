package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.domain.Student;
import com.bjpowernode.util.DBUtil;

public class RegisterServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到注册操作");
		
		//接收表单参数 用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into tbl_user(username,password) values(?,?)";
		
		try{
			
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			
			int count = ps.executeUpdate();
			
			System.out.println("受影响的行数为:"+count+"行");
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				DBUtil.myClose(conn, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * 以上是添加操作
		 * 以下是添加后,跳转到登录页
		 * 
		 * 转发还是重定向???
		 * 
		 * 转发:
		 * register.do
		 * 
		 * 重定向:
		 * login.html
		 * 
		 * 
		 */
		//request.getRequestDispatcher("/login.html").forward(request, response);
		response.sendRedirect("/1_servlet6/login.html");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

























