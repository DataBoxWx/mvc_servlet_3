package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet6 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet6");
		
		response.setContentType("text/html;charset=utf-8");
		
		request.setAttribute("str1","aaa");
		request.getSession().setAttribute("str2","bbb");
		this.getServletContext().setAttribute("str3","ccc");
		
		/*PrintWriter out = response.getWriter();
		out.print("域对象中的值设置完毕");
		out.close();*/
		
		//request.getRequestDispatcher("/myServlet7.do").forward(request, response);
		
		response.sendRedirect("/1_servlet7/myServlet7.do");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}



















