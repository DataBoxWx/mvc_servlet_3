package com.bjpowernode.controller;

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

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select count(*) from tbl_user where username=? and password=?";
		try {
			conn = Jutil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			res = ps.executeQuery();
			while(res.next()){
				int i = res.getInt(1);
				if(i == 1){
					request.getSession().setAttribute("username", username);
					response.sendRedirect(request.getContextPath() + "/student/list.do");
				}else {
					response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
