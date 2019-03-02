package com.bjpowernode.controller;

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

import com.bjpowernode.common.Jutil;
import com.bjpowernode.domain.Students;

/**
 * Servlet implementation class Login
 */
public class StudentDeletes extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] id = request.getParameterValues("id");
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from student where id=?";
		try {
			conn = Jutil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for (String string : id) {
				ps.setString(1, string);
				int i = ps.executeUpdate();
				System.out.println(i);
			}
			conn.commit();
		} catch (ClassNotFoundException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Jutil.myclose(conn, ps, null);
		}
		response.sendRedirect(request.getContextPath()+"/student/list.do");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
