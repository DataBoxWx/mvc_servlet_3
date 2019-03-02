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
		PrintWriter out = response.getWriter();
		int count =(Integer)this.getServletContext().getAttribute("str1");
		out.print("<html>");
		out.print("<body>");
		out.print("<table border='1'>");
		out.print("<tr>");
		out.print("<td colspan ='5'>");
		out.print("当前访问人数：" + count + "人");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
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
		out.print("性别");
		out.print("</td>");
		out.print("<td>");
		out.print("操作");
		out.print("</td>");
		out.print("</tr>");
		for(int i =0;i<list.size();i++){
			out.print("<tr>");
			out.print("<td>");
			out.print(list.get(i).getId());
			out.print("</td>");
			out.print("<td>");
			out.print(list.get(i).getName());
			out.print("</td>");
			out.print("<td>");
			out.print(list.get(i).getAge());
			out.print("</td>");
			out.print("<td>");
			out.print(list.get(i).getSex());
			out.print("</td>");
			out.print("<td>");
			out.print("<a href='/servlet_1_homework/deletestudent.do?id=" + list.get(i).getId() +"'>删除</a>");
			out.print("</td>");
			out.print("</tr>");
			
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	} 

}
