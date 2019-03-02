package com.bjpowernode.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.domain.Student;

public class MyServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet2");
		
		/*String strArr[] = {"aaa","bbb","ccc"};
		request.setAttribute("strArr",strArr);
		request.getRequestDispatcher("/test2.jsp").forward(request, response);*/
		
		/*List<String> sList = new ArrayList<String>();
		sList.add("abc");
		sList.add("bcd");
		sList.add("cde");		
		request.setAttribute("sList",sList);
		request.getRequestDispatcher("/test2.jsp").forward(request, response);*/
		
		/*Map<String,String> map = new HashMap<String,String>();
		map.put("str1","aaa");
		map.put("str2","bbb");
		request.setAttribute("myMap",map);
		request.getRequestDispatcher("/test2.jsp").forward(request, response);*/
		
		Student s = new Student("A0001","zs",23);
		request.setAttribute("s",s);
		request.getRequestDispatcher("/test2.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}












