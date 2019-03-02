package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入myServlet1"); 
		
		//{"str1":"aaa"}
		String str1 = "{\"str1\":\"aaa\"}";
		
		request.setAttribute("data",str1);
		
		request.getRequestDispatcher("/data.jsp").forward(request, response);
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("经过post方法");
		this.doGet(request, response);
	}

}












