package com.bjpowernode.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StudentListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		
		
		if(username!=null){
			
			request.getRequestDispatcher("/WEB-INF/html/student/index.html").forward(request, response);
			
		//没登录过
		}else{
			
			response.sendRedirect(request.getContextPath() + "/login.html");
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
