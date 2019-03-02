package com.bjpowernode.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet1");
		
		Cookie cookie1 = new Cookie("str1","aaa");
		Cookie cookie2 = new Cookie("str2","bbb");
		Cookie cookie3 = new Cookie("str3","ccc");
		
		//cookie1.setPath("/1_servlet7");
		
		cookie1.setMaxAge(60*60*24*10);
		cookie2.setMaxAge(60);
		cookie3.setMaxAge(120);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
