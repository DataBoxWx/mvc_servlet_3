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

public class StudentEditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到跳转到编辑页操作(根据id查单条)");
		
		//接收需要编辑记录的id
		String id = request.getParameter("id");
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select name,age from tbl_student where id=?";
		Student s = new Student();
		
		try{
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				s.setId(id);
				s.setName(rs.getString(1));
				s.setAge(rs.getInt(2));
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				DBUtil.myClose(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//单条s取到了
		request.setAttribute("s",s);
		request.getRequestDispatcher("/jsp/student/edit.jsp").forward(request, response);
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

























