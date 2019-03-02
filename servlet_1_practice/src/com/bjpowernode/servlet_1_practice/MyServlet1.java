package com.bjpowernode.servlet_1_practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.domain.Students;
public class MyServlet1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Students stu1 = new Students("aa", 11,'m'); 
		Students stu2 = new Students("bb", 12,'w'); 
		Students stu3 = new Students("cc", 13,'m'); 
		Students stu4 = new Students("dd", 14,'w'); 
		List<Students> str = new ArrayList<>();
		str.add(stu1);
		str.add(stu2);
		str.add(stu3);
		str.add(stu4);
		PrintWriter out = response.getWriter();		
		out.print("<html>");
		out.print("<body>");
		out.print("<table border='1'>");
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
		out.print("</tr>");
		for(int i = 0;i < str.size();i++){
			out.print("<tr>");
			out.print("<td>");
			out.print(i+1);
			out.print("</td>");
			out.print("<td>");
			out.print(str.get(i).getName());
			out.print("</td>");
			out.print("<td>");
			out.print(str.get(i).getAge());
			out.print("</td>");
			out.print("<td>");
			out.print(str.get(i).getSex());
			out.print("</td>");
			out.print("</tr>");			
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
