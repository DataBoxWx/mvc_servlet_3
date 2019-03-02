package com.bjpowernode.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.service.UserService;
import com.bjpowernode.service.impl.UserServiceImpl;
import com.bjpowernode.util.ServiceFactory;

public class UserController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService userService = (UserService) ServiceFactory.getProxy(new UserServiceImpl());
		Boolean flag = userService.Flag(username,password);
		if(flag){
			request.getSession().setAttribute("username", username);
			response.sendRedirect(request.getContextPath() +"/jsp/studentlist.jsp");
		}else {
			response.sendRedirect(request.getContextPath() +"/login.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
