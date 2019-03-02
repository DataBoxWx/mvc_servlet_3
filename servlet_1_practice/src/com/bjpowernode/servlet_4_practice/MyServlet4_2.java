package com.bjpowernode.servlet_4_practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet4_2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet2");
		Cookie[] cookies = request.getCookies();
		PrintWriter out = response.getWriter();
		if(cookies != null && cookies.length > 0){
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				System.out.println(cookie.getValue());
				out.print("*************");
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
