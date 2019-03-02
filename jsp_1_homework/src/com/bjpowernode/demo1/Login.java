package com.bjpowernode.demo1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.common.Jutil;


public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select count(*) from tbl_user where username=? and password=?";
		
		try {
			System.out.println("进入登陆页面");
			conn = Jutil.getConnection();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			res = ps.executeQuery();
			
			while(res.next()){
				int a = res.getInt(1);
				if(a == 1){
					request.getSession().setAttribute("username", username);
					response.sendRedirect(request.getContextPath() + "/studentlist.do");
				}else {
					response.sendRedirect(request.getContextPath() + "/login.html");
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Jutil.close1(conn, ps, res);;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
