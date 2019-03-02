package com.bjpowernode.operation;

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

public class StudentList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select id,name,age,sex from students";
		List<Students> list = new ArrayList<Students>();
		try {
			conn = Jutil.getConnection();
			ps = conn.prepareStatement(sql);			
			res=ps.executeQuery();
			while(res.next()){
				Students  stu = new Students();
				stu.setId(res.getString(1));
				stu.setName(res.getString(2));
				stu.setAge(res.getInt(3));
				stu.setSex(res.getString(4).charAt(0));
				list.add(stu);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/studentlist.jsp").forward(request, response);;
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	} 

}
