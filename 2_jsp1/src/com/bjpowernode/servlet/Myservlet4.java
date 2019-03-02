package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.common.Jutil;
import com.bjpowernode.domain.Student;

public class Myservlet4 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入servlet4");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Student stu1 = new Student("A0001", "小红", 18);
		Student stu2 = new Student("A0002", "小黄", 19);
		Student stu3 = new Student("A0003", "小程", 20);
		Student stu4 = new Student("A0004", "小绿", 21);
		Student stu5 = new Student("A0005", "小紫", 17);
		List<Student> list = new ArrayList<>();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		list.add(stu5);
		//{"list":[{"id":"?","name":"?",age:"?"},{"id":"?","name":"?","age":"?"}]}
		//str ="{"id":"?","name":"?",age:"?"}";
		StringBuffer buffer= new StringBuffer();
		buffer.append("{\"list\":[");
		for(int i = 0;i < list.size();i++){
			Student stu = list.get(i);
		//	buffer.append("{\"id\":\""+stu.getId()+"\",\"name\":\""+stu.getName()+"\",age:\""+stu.getAge()+"\"}");
			buffer.append("{\"id\":\"");
			buffer.append(stu.getId());
			buffer.append("\",\"name\":\"");
			buffer.append(stu.getName());
			buffer.append("\",\"age\":\"");
			buffer.append(stu.getAge());
			buffer.append("\"}");
			if(i < list.size()-1){
				buffer.append(",");
			}
		
		}
		buffer.append("]}");
		System.out.println(buffer);
		out.print(buffer.toString());
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
