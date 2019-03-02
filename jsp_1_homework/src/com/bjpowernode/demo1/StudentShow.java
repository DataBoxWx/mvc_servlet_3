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

import com.bjpowernode.common.Jutil;
import com.bjpowernode.domain.Student;

/**
 * Servlet implementation class Login
 */
public class StudentShow extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select id,name,age from student where id=?";
		Student stu = new Student();
		try {
			conn = Jutil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			res = ps.executeQuery();
			if(res.next()){				
				stu.setId(res.getString(1));
				stu.setName(res.getString(2));
				stu.setAge(res.getInt(3));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("student", stu);
		request.getRequestDispatcher("/jsp/studentupdate.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
