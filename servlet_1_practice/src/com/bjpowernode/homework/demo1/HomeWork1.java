package com.bjpowernode.homework.demo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeWork1 extends HttpServlet {
	//�����½����
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<center>");
		out.print("<form action='/servlet_1_practice/homework2.do'>");
		out.print("�û���<input type='text' name=username><br>");
		out.print("����<input type='password' name=password><br>");
		out.print("<input type='submit' value = '�ύ'>");
		out.print("</form>");
		out.print("</center>");
		out.print("</body>");
		out.print("</html>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
