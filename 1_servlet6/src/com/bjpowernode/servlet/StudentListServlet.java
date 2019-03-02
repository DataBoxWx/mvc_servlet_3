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
		
		System.out.println("进入到查询显示学生信息列表操作");
		
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
		 * 以上为取得学生信息列表的过程
		 * 以下为通过响应流展现学生信息列表
		 */
		
		
		//显示当前访问人次
		int count = (Integer)this.getServletContext().getAttribute("count");
		
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<table border='1'>");
		
		out.print("<tr>");
		out.print("<td colspan='5'>");
		out.print("当前访问人次为:"+count+"人");
		out.print("</td>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<td>");
		out.print("序号");
		out.print("</td>");
		out.print("<td>");
		out.print("编号");
		out.print("</td>");
		out.print("<td>");
		out.print("姓名");
		out.print("</td>");
		out.print("<td>");
		out.print("年龄");
		out.print("</td>");
		
		out.print("<td>");
		out.print("操作");
		out.print("</td>");
		
		out.print("</tr>");
		
		for(int i=0;i<sList.size();i++){
			
			//取得每一个学生
			Student s = sList.get(i);
			
			out.print("<tr>");
			out.print("<td>");
			out.print(i+1);
			out.print("</td>");
			out.print("<td>");
			out.print(s.getId());
			out.print("</td>");
			out.print("<td>");
			out.print(s.getName());
			out.print("</td>");
			out.print("<td>");
			out.print(s.getAge());
			out.print("</td>");
			
			out.print("<td>");
			out.print("<a href='/1_servlet6/student/delete.do?id="+s.getId()+"'>删除</a>");
			out.print("</td>");
			
			out.print("</tr>");
			
			
		}
		
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

























