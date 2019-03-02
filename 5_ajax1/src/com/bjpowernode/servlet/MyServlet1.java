package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet {
	
	/*
	 * 如果servlet接收的请求为传统的全局刷新的请求,那么响应流响应的内容就是浏览器上的内容
	 * 如果servlet接收的请求为ajax发送的局部刷新的请求,那么响应流的内容就是作为ajax的返回值存在
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet1");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String str1 = request.getParameter("str1");
		String str2 = request.getParameter("str2");
		
		System.out.println(str1);
		System.out.println(str2);
		
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		PrintWriter out = response.getWriter();
		out.print(str1+";"+str2);
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入到doPost方法");
		this.doGet(request, response);
	}

}









