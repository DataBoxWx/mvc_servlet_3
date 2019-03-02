 package com.bjpowernode.crud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.crud.service.UserService;
import com.bjpowernode.crud.service.impl.UserServiceImpl;
import com.bjpowernode.crud.util.ServiceFactory;

public class UserController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserService userService = (UserService)ServiceFactory.getService(userServiceImpl);
		Boolean flag = userService.login(username,password);
		if(flag){
			request.getSession().setAttribute("username", username);
			response.sendRedirect(request.getContextPath()+"/ajax/studentlist.jsp");
		}else {
			response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
