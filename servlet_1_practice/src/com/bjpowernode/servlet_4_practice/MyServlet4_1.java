package com.bjpowernode.servlet_4_practice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet4_1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet1");
		Cookie cookie1 = new Cookie("cook1", "aa");
		Cookie cookie2 = new Cookie("cook2", "bb");
		Cookie cookie3 = new Cookie("cook3", "cc");
		cookie1.setMaxAge(30);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
