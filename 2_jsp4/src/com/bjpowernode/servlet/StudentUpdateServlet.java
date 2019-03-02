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

import com.bjpowernode.domain.Student;
import com.bjpowernode.util.DBUtil;
import com.bjpowernode.util.UUIDUtil;

public class StudentUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到修改学生操作");
		
		//接收表单信息
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		int age = Integer.valueOf(ageStr);
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update tbl_student set name=?,age=? where id=?";
		
		try{
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,name);
			ps.setInt(2,age);
			ps.setString(3,id);
			
			ps.executeUpdate();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				DBUtil.myClose(conn, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * 以上为修改学员操作
		 * 以下为添加学员后跳转到哪?
		 * 跳转到列表页
		 * 转发还是重定向?
		 * 重定向
		 * 
		 * 重定向到list.do还是重定向到index.jsp???
		 * list.do
		 * 
		 */
		response.sendRedirect(request.getContextPath() + "/student/list.do");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

























