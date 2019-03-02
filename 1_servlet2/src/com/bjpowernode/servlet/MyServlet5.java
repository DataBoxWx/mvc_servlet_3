package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet5 extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到servlet5");
		
		/*
		 * 为浏览器响应信息,我们使用响应流对象
		 * 	PrintWriter out = response.getWriter();
		 * 注意:变量名 叫out
		 * 	响应信息,我们需要使用out对象调用print方法
		 * 	print方法中的实参,就是我们要为浏览器响应的内容
		 * 	
		 */
		
		//在响应内容之前,需要将响应流的字符编码设置为utf-8
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<font color='red'>你好,世界!!!</font>");
		out.print("</body>");
		out.print("</html>");
		out.close();
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}
	
}





















































