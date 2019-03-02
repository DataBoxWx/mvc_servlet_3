package com.bjpowernode.servlet_5_practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet5_3 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet3");
//		System.out.println(request.getContextPath());
//		String aa = request.getServletPath();
//		System.out.println(aa);
//		String method = request.getMethod();
//		System.out.println(method);
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println(requestURI);
		System.out.println(requestURL);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
