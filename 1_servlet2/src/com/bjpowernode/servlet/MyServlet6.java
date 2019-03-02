package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.domain.Student;

public class MyServlet6 extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到servlet5");
		
		response.setContentType("text/html;charset=utf-8");
		
		/*
		 * 1.创建5个学生
		 * 2.将学生存储在集合中
		 * 3.将集合中的内容通过响应流的形式输出到浏览器上
		 * 		输出的html格式为table表格
		 */
		
		Student s1 = new Student("A0001","zs",23);
		Student s2 = new Student("A0002","ls",24);
		Student s3 = new Student("A0003","ww",25);
		Student s4 = new Student("A0004","zl",26);
		Student s5 = new Student("A0005","sq",27);
		
		List<Student> sList = new ArrayList<Student>();
		sList.add(s1);
		sList.add(s2);
		sList.add(s3);
		sList.add(s4);
		sList.add(s5);
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<table border='1'>");
		
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
			out.print("</tr>");
			
			
		}
		
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}
	
}





















































