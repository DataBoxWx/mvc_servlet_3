package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.domain.Student;

public class MyServlet3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet2");
		
		Student s = new Student("A0001","zs",23);
		
		//{"id":"?","name":"?","age":?}
		
		String str = "{\"id\":\""+s.getId()+"\",\"name\":\""+s.getName()+"\",\"age\":"+s.getAge()+"}";
		
		System.out.println(str);
		
		PrintWriter out = response.getWriter();
		out.print(str);
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入到doPost方法");
		this.doGet(request, response);
	}

}









