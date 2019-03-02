package com.bjpowernode.servlet_5_practice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet5_1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet1");
		request.setAttribute("str1", "aa");
		request.getSession().setAttribute("str2", "bb");
		this.getServletContext().setAttribute("str3", "cc");
		request.getRequestDispatcher("/servlet_1_practice/myservlet5_2").forward(request, response);
   	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
