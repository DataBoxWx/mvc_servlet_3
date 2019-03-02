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

public class StudentListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到查询学生信息列表操作");
		
		response.setContentType("text/html;charset=utf-8");
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id,name,age from tbl_student";
		List<Student> sList = new ArrayList<Student>();
		
		try{
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				Student s = new Student();
				
				s.setId(rs.getString(1));
				s.setName(rs.getString(2));
				s.setAge(rs.getInt(3));
				
				sList.add(s);
				
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
		
		/*
		 * 以上为取sList的过程
		 * 以下为将sList打包到某个域中
		 * 打包到哪个域中??????
		 * 既然我们定下来使用转发了,那么我们可以将sList保存到哪个域?
		 * 所以request域是最好的选择
		 * 
		 * 
		 * 使用转发还是重定向?
		 * 转发后的路径
		 * http://localhost:8080/2_jsp2/student/list.do
		 * 
		 * 
		 * 重定向后的路径
		 * http://localhost:8080/2_jsp2/jsp/student/index.jsp
		 * 
		 * 以上两个路径哪个是我们想要刷新的?
		 * 我们要刷的路径是 http://localhost:8080/2_jsp2/student/list.do
		 * 
		 * 
		 * 
		 */
		
		request.setAttribute("sList",sList);
		request.getRequestDispatcher("/jsp/student/index.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/jsp/student/index.jsp");
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

























