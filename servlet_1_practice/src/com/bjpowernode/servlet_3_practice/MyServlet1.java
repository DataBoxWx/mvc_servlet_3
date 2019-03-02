package com.bjpowernode.servlet_3_practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入servlet1");
//		request.getRequestDispatcher("/WEB-INF/Practice_10.html").forward(request, response);
//		response.sendRedirect("/WEB-INF/Practice_10.html");  	找不到路径
		response.sendRedirect("/servlet_1_practice/Myservlet.do");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response); 
	}
}
