package com.bjpowernode.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet4 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet3");
		
		List<String> sList = new ArrayList<String>();
		sList.add("aaa");
		sList.add("bbb");
		sList.add("ccc");
		sList.add("ddd");
		sList.add("eee");
		sList.add("fff");
		request.setAttribute("sList",sList);
		
		request.getRequestDispatcher("/test7.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}












