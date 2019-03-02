package com.bjpowernode.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet3");
		
		/*
		 * 重定向:
		 * 	语法:
		 * 		response.sendRedirect("")
		 * 	方法中的参数为跳转的路径
		 *  路径的写法:
		 *  	传统的绝对路径  加/项目名	
		 * 
		 *  
		 *  注意:
		 *  	路径变为新路径
		 * 
		 */
		
		//1.重定向到一个普通的html页面
		//response.sendRedirect("/1_servlet4/test1.html");
		
		
		//2.重定向到WEB-INF下的资源
		/*
		 * 由于路径变为新路径,出现了WEB-INF这几个字符,所以访问不到
		 */
		//response.sendRedirect("/1_servlet4/WEB-INF/html/test1.html");
		
		
		//3.重定向到其他的servlet
		response.sendRedirect("/1_servlet4/myServlet4.do");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
















