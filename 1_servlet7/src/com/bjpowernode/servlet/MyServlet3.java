package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet3");
		
		/*
		 * 创建/取得 session对象
		 * 	request.getSession()
		 *  使用上述代码,如果服务器中有一个有效的session,那么该方法将服务器中存的session返回
		 *  使用上述代码,,如果服务器中没有一个有效的session,那么该方法为我们返回一个新创建的session对象
		 *  
		 */
		
		HttpSession session = request.getSession();
		
		session.setMaxInactiveInterval(10);
		
		boolean flag = session.isNew();
		
		String sessionId = session.getId();
		
		PrintWriter out = response.getWriter();
		out.print(flag+":"+sessionId);
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}



















