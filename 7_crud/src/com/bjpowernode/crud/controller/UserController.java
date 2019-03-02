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
		
		System.out.println("进入到用户操作模块");
		
		//接收表单数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService userService = (UserService) ServiceFactory.getService(new UserServiceImpl());
		
		//业务层调用登录业务
		//参数写什么,返回值写什么
		boolean flag = userService.login(username,password);
		
		//登录成功
		if(flag){
			
			request.getSession().setAttribute("username",username);
			
			response.sendRedirect(request.getContextPath() + "/jsp/student/index.jsp");
			
		//登录失败
		}else{
			
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}
	
}





























