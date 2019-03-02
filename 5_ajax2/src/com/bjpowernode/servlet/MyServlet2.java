package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet2");
		
		//{"str1":"aaa","str2":"bbb"}
		
		String str = "{\"str1\":\"aaa\",\"str2\":\"bbb\"}";
		
		System.out.println(str);
		
		PrintWriter out = response.getWriter();
		out.print(str);
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入到doPost方法");
		this.doGet(request, response);
	}

}









