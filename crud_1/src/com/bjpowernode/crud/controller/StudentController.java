 package com.bjpowernode.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.crud.domain.Students;
import com.bjpowernode.crud.service.StudentService;
import com.bjpowernode.crud.service.impl.StudentServiceImpl;
import com.bjpowernode.crud.util.PageUtil;
import com.bjpowernode.crud.util.ServiceFactory;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class StudentController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		StudentService studentService  = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
		String path = request.getServletPath();
		if("/controller/list.do".equals(path)){
			
			list(request,response,studentService);
			
		}else if("/controller/save.do".equals(path)){
			
			save(request,response,studentService);
			response.sendRedirect(request.getContextPath()+"/ajax/studentlist.jsp");
			
		}else if("/controller/delete.do".equals(path)){
			
			delete(request,response,studentService);
			response.sendRedirect(request.getContextPath()+"/ajax/studentlist.jsp");
			
		}else if("/controller/update.do".equals(path)){
			
			update(request,response,studentService);
			response.sendRedirect(request.getContextPath()+"/ajax/studentlist.jsp");
			
		}else if("/controller/edit.do".equals(path)){
			edit(request,response,studentService);
		}
	}
	private void edit(HttpServletRequest request, HttpServletResponse response, StudentService studentService) throws IOException {
		String id = request.getParameter("id");
		 
		Students stu = studentService.getStudentById(id);
		StringBuffer buffer = new StringBuffer();
		//{"id":"?","name":"?","age":?}
		buffer.append("{\"id\":\"");
		buffer.append(stu.getId());
		buffer.append("\",\"name\":\"");
		buffer.append(stu.getName());
		buffer.append("\",\"age\":");
		buffer.append(stu.getAge());
		buffer.append("}");
		PrintWriter out = response.getWriter();
		out.print(buffer.toString());
		out.close();
		
	}
	private void update(HttpServletRequest request, HttpServletResponse response, StudentService studentService) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		int age = Integer.valueOf(ageStr);
		Students stu = new Students();
		stu.setId(id);
		stu.setName(name);
		stu.setAge(age);
		studentService.updateStudent(stu);
		
	}
	private void delete(HttpServletRequest request, HttpServletResponse response, StudentService studentService) {
		String id = request.getParameter("id");
		studentService.deleteStudent(id);
	}
	private void save(HttpServletRequest request, HttpServletResponse response, StudentService studentService) {
		System.out.println("进入添加学生操作");
		String name = request.getParameter("username");
		String ageStr = request.getParameter("age");
		int age = Integer.valueOf(ageStr);
		Students stu = new Students();
		stu.setName(name);
		stu.setAge(age);
		studentService.addStudent(stu);
		
	}
	private void list(HttpServletRequest request, HttpServletResponse response, StudentService studentService) throws IOException {
		System.out.println("进入学生列表操作");
		String pageNu = request.getParameter("pageNu");
		Map<String, Object> map = studentService.getAll(pageNu);
		StringBuffer buffer = new StringBuffer();
		PageUtil pu = (PageUtil) map.get("pu");
		List<Students> slist = (List<Students>) map.get("slist");
		//{"pu":{"pageSize":?,"pageNu":?,"pageCount":?,"total":?},{"slist":[{"id":}
		buffer.append("{\"pu\":{\"pageSize\":");
		buffer.append(pu.getPageSize());
		buffer.append(",\"pageNu\":");
		buffer.append(pu.getPageNu());
		buffer.append(",\"pageCount\":");
		buffer.append(pu.getPageCount());
		buffer.append(",\"total\":");
		buffer.append(pu.getTotal());
		buffer.append("},\"slist\":[");
		
/*		{"slist":[{"id":"?","name":"?","age":?}]}
		buffer.append("{\"slist\":[");*/
		for(int i = 0; i< slist.size();i++){
			Students stu = slist.get(i);
			buffer.append("{\"id\":\"");
			buffer.append(stu.getId());
			buffer.append("\",\"name\":\"");
			buffer.append(stu.getName());
			buffer.append("\",\"age\":");
			buffer.append(stu.getAge());
			buffer.append("}");
			if( i< slist.size()-1){
				buffer.append(",");
			}
		}
		buffer.append("]}");
		System.out.println(buffer);
		PrintWriter out = response.getWriter();
		out.print(buffer.toString());
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
