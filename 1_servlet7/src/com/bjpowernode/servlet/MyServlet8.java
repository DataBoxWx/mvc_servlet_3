package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet8 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet8");
		
		/*String method = request.getMethod();
		System.out.println(method);*/
		
		// /项目名 /1_servlet7
		/*String path = request.getContextPath();
		System.out.println(path);*/
		//response.sendRedirect(request.getContextPath() + "/myServlet8.do");
		
		/*String path1 = request.getRequestURI();
		StringBuffer path2 = request.getRequestURL();
		System.out.println(path1);
		System.out.println(path2.toString());*/
		
		/*String ip = request.getRemoteAddr();
		System.out.println(ip);*/
		
		/*String path = request.getServletPath();
		System.out.println(path);*/
		
		/*String hobbys[] = request.getParameterValues("hobby");
		
		for(String hobby:hobbys){
			System.out.println(hobby);
		}*/
		
		String str = null;
		str.substring(0);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}



















