package com.bjpowernode.demo1;

import java.io.IOException;
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

import com.bjpowernode.common.JUUID;
import com.bjpowernode.common.Jutil;
import com.bjpowernode.domain.Student;

/**
 * Servlet implementation class Login
 */
public class StudentDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Connection conn = null;
		PreparedStatement ps = null;
	
		String sql = "delete from student where id=?";

		try {
			conn = Jutil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int i = ps.executeUpdate();
			System.out.println(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Jutil.close1(conn, ps, null);
		}
		response.sendRedirect(request.getContextPath() + "/studentlist.do");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
