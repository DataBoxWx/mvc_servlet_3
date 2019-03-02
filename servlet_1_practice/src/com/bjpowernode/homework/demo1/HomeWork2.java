package com.bjpowernode.homework.demo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.domain.Students;

public class HomeWork2 extends HttpServlet {
	//��ȡ��½���˻������벢�����ж�
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(user.equals("wx") && password.equals("password")){				
			Students stu1 = new Students("aa", 11,'m'); 
			Students stu2 = new Students("bb", 12,'w'); 
			Students stu3 = new Students("cc", 13,'m'); 
			Students stu4 = new Students("dd", 14,'w'); 
			List<Students> str = new ArrayList<>();
			str.add(stu1);
			str.add(stu2);
			str.add(stu3);
			str.add(stu4);	
			out.print("<html>");
			out.print("<body>");
			out.print("<table border='1'>");
			out.print("<tr>");
			out.print("<td>");
			out.print("���");
			out.print("</td>");
			out.print("<td>");
			out.print("����");
			out.print("</td>");
			out.print("<td>");
			out.print("����");
			out.print("</td>");
			out.print("<td>");
			out.print("�Ա�");
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
		}else{
			out.print("<html>");
			out.print("<body>");
			out.print("<center>");
			out.print("�����˻������벻��ȷ������������");
			out.print("</center>");
			out.print("</body>");
			out.print("</html>");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
