package com.bjpowernode.homework.demo2;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.common.util.Jutilcom;

public class Judge extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		int count = 0;
		this.getServletContext().setAttribute("count",count);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String str = request.getParameter("username");
		 String res = request.getParameter("password");
		 Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet re = null;
		 
		 try {
			conn = Jutilcom.getConnection();
			String sql = "select count(*) from tbl_user where username=? and password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, str);
			ps.setString(2, res);
			re = ps.executeQuery();
			if(re.next()){
				int i = re.getInt(1);
				if(i == 1){
					int count =(Integer) this.getServletContext().getAttribute("count");
					count++;
					this.getServletContext().setAttribute("count",count);
//					request.getRequestDispatcher("/loadin.do").forward(request, response);;
					response.sendRedirect("/servlet_1_practice/loadin.do");
				}else{
//					request.getRequestDispatcher("/pra/defeated.html").forward(request, response);;
					response.sendRedirect("/servlet_1_practice/pra/defeated.html");
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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
