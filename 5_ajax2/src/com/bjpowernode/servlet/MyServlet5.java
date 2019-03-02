package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.domain.Student;

public class MyServlet5 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet5");
		
		Student s1 = new Student("A0001","zs",23);
		Student s2 = new Student("A0002","ls",24);
		Student s3 = new Student("A0003","ww",25);
		Student s4 = new Student("A0004","zl",26);
		Student s5 = new Student("A0005","sq",27);
		
		List<Student> sList = new ArrayList<Student>();
		sList.add(s1);
		sList.add(s2);
		sList.add(s3);
		sList.add(s4);
		sList.add(s5);
		
		//{"sList":[{"id":"?","name":"?","age":?},{"id":"?","name":"?","age":?},{"id":"?","name":"?","age":?}]}
		
		StringBuffer buf = new StringBuffer();
		buf.append("{\"sList\":[");
		
		for(int i=0;i<sList.size();i++){
			
			Student s = sList.get(i);
			
			//buf.append("{\"id\":\""+s.getId()+"\",\"name\":\""+s.getName()+"\",\"age\":"+s.getAge()+"}");
			
			buf.append("{\"id\":\"");
			buf.append(s.getId());
			buf.append("\",\"name\":\"");
			buf.append(s.getName());
			buf.append("\",\"age\":");
			buf.append(s.getAge());
			buf.append("}");
			
			if(i<sList.size()-1){
				
				buf.append(",");
				
			}
			
		}
		
		buf.append("]}");
		
		String str = buf.toString();
		
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









