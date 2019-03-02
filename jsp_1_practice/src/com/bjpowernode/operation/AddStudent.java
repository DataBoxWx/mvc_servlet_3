package com.bjpowernode.operation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.common.JUUID;
import com.bjpowernode.common.Jutil;

public class AddStudent extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		int age = Integer.valueOf(ageStr);
		String sex = request.getParameter("sex");
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into students(id,name,age,sex) values(?,?,?,?)";
		try {
			conn = Jutil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, JUUID.getUUId());
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setString(4, sex);
			int i = ps.executeUpdate();
			System.out.println(i);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Jutil.closer(conn, ps, null);
		}
		response.sendRedirect("/jsp_1_practice/studentlist.do");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
