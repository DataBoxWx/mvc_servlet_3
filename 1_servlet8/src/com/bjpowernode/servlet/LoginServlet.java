package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.util.DBUtil;

public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到登录操作");
		
		response.setContentType("text/html;charset=utf-8");
		
		//接收表单参数 用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		/*
		 * 1.声明所需变量
		 * 2.搭建try catch finally 结构
		 * 3.填充代码
		 */
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from tbl_user where username=? and password=?";
		boolean flag = true;
		
		try{
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			/*
			 * ps创建完之后,养成习惯,观察你的sql语句,如果有?,需要使用ps对?进行赋值
			 */
			ps.setString(1,username);
			ps.setString(2,password);
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				int count = rs.getInt(1);
				/*
				 * count:0 没有查询到记录 登录失败
				 * count:1 查询到了相应的用户名密码 登录成功
				 * count:>1 表中有垃圾数据 登录失败
				 */
				
				if(count!=1){
					flag = false;
				}
				
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				DBUtil.myClose(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//登录成功
		if(flag){
			
			request.getSession().setAttribute("username",username);
			
			response.sendRedirect(request.getContextPath() + "/student/list.do");
			
		
		//登录失败
		}else{
		
			response.sendRedirect(request.getContextPath() + "/login.html");
			
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

























