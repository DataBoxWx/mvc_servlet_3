package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet7 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet6");
		
		String str1 = (String)request.getAttribute("str1");
		String str2 = (String)request.getSession().getAttribute("str2");
		String str3 = (String)this.getServletContext().getAttribute("str3");
		
		PrintWriter out = response.getWriter();
		out.print("str1="+str1+";str2="+str2+";str3="+str3);
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}



















