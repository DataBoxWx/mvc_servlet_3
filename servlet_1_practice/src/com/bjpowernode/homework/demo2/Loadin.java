package com.bjpowernode.homework.demo2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.common.util.Jutilcom;
import com.bjpowernode.domain.Students;

public class Loadin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		int count =(Integer) this.getServletContext().getAttribute("count");
		
		
		Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet re = null;
		 PrintWriter out = response.getWriter();
		 out.print("<html>");
		 out.print("<body>");
		 out.print("<form>");
		 out.print("<table border=1>");
		 
		 out.print("<tr >");
		 out.print("<td colspan='5'>");
		 out.print("当前访问人数为：" + count +"人");
		 out.print("</td>");
		 out.print("</tr>");
		 
		 out.print("<tr>");
		 out.print("<td>");
		 out.print("ID");
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
		 out.print("是否删除");
		 out.print("</td>");
		 out.print("</tr>");
		 List<Students> list = new ArrayList<>();
		 try {
			conn = Jutilcom.getConnection();
			String sql = "select id,name,age,sex from student";
			ps = conn.prepareStatement(sql);
		
			re = ps.executeQuery();
			
			while(re.next()){
				Students stu =new Students();
				stu.setId(re.getInt(1));
				stu.setName(re.getString(2));
				stu.setAge(re.getInt(3));
				stu.setSex(re.getString(4).charAt(0));
				list.add(stu);
				
				
			}
			for(int i =0;i <list.size();i++){
				
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
				 out.print("<a href='/servlet_1_practice/delete.do?id="+list.get(i).getId()+"'>删除</a>");
				 out.print("</td>");
				 out.print("</tr>");
			}
			out.print("</table>");
			out.print("</from>");
			 out.print("</body>");
			 out.print("</html>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}

