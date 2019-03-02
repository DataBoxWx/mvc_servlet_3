package com.bjpowernode.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet3 extends HttpServlet {

	/*@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet3");
		
		/*
		 * ServletConfig对象的取得:
		 * 		this.getServletConfig()
		 * 注意:
		 * 		变量名必须叫config
		 * 	
		 */
		
		//1.取得servlet-name
		/*ServletConfig config = this.getServletConfig();
		String sname = config.getServletName();
		System.out.println(sname);*/
		
		//2.取得web.xml中配置在该servlet中的参数
		/*ServletConfig config = this.getServletConfig();
		String str = config.getInitParameter("encoding");
		System.out.println(str);
		
		request.setCharacterEncoding(str);*/
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}





















