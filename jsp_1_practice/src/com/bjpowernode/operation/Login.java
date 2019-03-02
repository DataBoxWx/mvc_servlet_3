package com.bjpowernode.operation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.common.Jutil;

public class Login extends HttpServlet{
	@Override
	public void init() throws ServletException {
		int count = 0;
		this.getServletContext().setAttribute("str1", count);

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("username");
		String passwrod = request.getParameter("password");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select count(*) from tbl_user where username=? and password=?";
		try {
			conn = Jutil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, passwrod);
			res=ps.executeQuery();
			while(res.next()){
				int i = res.getInt(1);
				if(i==1){
					int count =(Integer)this.getServletContext().getAttribute("str1");
					count++;
					this.getServletContext().setAttribute("str1", count);
					request.getSession().setAttribute("user", user);
					response.sendRedirect("/jsp_1_practice/studentlist.do");
				}else {
					response.sendRedirect("/jsp_1_practice/fail.html");
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Jutil.closer(conn, ps, res);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	} 

}
