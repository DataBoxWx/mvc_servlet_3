package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.domain.Student;

public class MyServlet4 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet2");
		
		Student s1 = new Student("A0001","zs",23);
		Student s2 = new Student("A0002","ls",24);
		
		//{"s1":{"id":"?","name":"?","age":?},"s2":{"id":"?","name":"?","age":?}}
		
		String str = "{\"s1\":{\"id\":\""+s1.getId()
		+"\",\"name\":\""+s1.getName()
		+"\",\"age\":"+s1.getAge()
		+"},\"s2\":{\"id\":\""+s2.getId()
		+"\",\"name\":\""+s2.getName()
		+"\",\"age\":"+s2.getAge()+"}}";
		
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









