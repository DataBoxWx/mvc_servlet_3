package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet1");
		response.setContentType("text/html;charset=utf-8");
		/*
		 * 上下文对象的取得:
		 * 取得方式1:先取得ServletConfig对象,再由SevletConfig对象取得上下文对象
		 * 			this.getServletConfig().getServletContext()
		 * 取得方式2:直接取得上下文对象
		 * 			this.getServletContext()
		 * 
		 * 注意:
		 * 	(1)在实际项目开发中,我们使用第二种方式即可,因为方便.
		 *  (2)虽然我们使用的是第二种方式,但是其实内部的代码调用仍然使用的是第一种方式.
		 *  (3)上下文对象,命名必须叫application
		 * 
		 */
		
		
		//1.取得全局初始化参数
		/*ServletContext application = this.getServletContext();
		String str1 = application.getInitParameter("encoding");
		System.out.println(str1);
		
		request.setCharacterEncoding(str1);
		response.setContentType("text/html;charset="+str1);*/
		
		
		//2.当做域对象来存取值
		/*ServletContext application = this.getServletContext();
		application.setAttribute("str1","abc");
		
		PrintWriter out = response.getWriter();
		out.print("上下文域中的值存储完毕");
		out.close();*/
		
		
		//3.取得项目的发布路径
		ServletContext application = this.getServletContext();
		String path = application.getRealPath("/");
		System.out.println(path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}




















