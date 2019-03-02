package com.bjpowernode.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.domain.Students;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.service.impl.StudentServiceImpl;
import com.bjpowernode.service.impl.UserServiceImpl;
import com.bjpowernode.util.PageNumber;
import com.bjpowernode.util.ServiceFactory;

public class StudentController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService studentService = (StudentService) ServiceFactory.getProxy(new StudentServiceImpl());
		String path = request.getServletPath();
		if("/student/list.do".equals(path)){
			studentList(request,response,studentService);
		}else if ("/student/add.do".equals(path)) {
			studentAdd(request,response,studentService);
			response.sendRedirect(request.getContextPath()+"/jsp/studentlist.jsp");
		}else if ("/student/delete.do".equals(path)) {
			studentDelete(request,response,studentService);
			response.sendRedirect(request.getContextPath()+"/jsp/studentlist.jsp");
		}else if ("/student/edit.do".equals(path)) {
			studentEdit(request,response,studentService);
		}else if ("/student/update.do".equals(path)) {
			studentUpdate(request,response,studentService);
			response.sendRedirect(request.getContextPath()+"/jsp/studentlist.jsp");
		}
	}
	private void studentUpdate(HttpServletRequest request, HttpServletResponse response, StudentService studentService) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		studentService.update(id,name,ageStr);
		
	}
	private void studentEdit(HttpServletRequest request, HttpServletResponse response, StudentService studentService) throws IOException {
		String id = request.getParameter("id");
		Students s  = studentService.getStu(id);
		//{"id":"?","name":"?","age":?}
		String str = "{\"id\":\""+s.getId()+"\",\"name\":\""+s.getName()+"\",\"age\":"+s.getAge()+"}";
		System.out.println(str);
		PrintWriter out = response.getWriter();
		out.print(str);
		out.close();
	}
	private void studentDelete(HttpServletRequest request, HttpServletResponse response, StudentService studentService) {
		String id = request.getParameter("id");
		studentService.delete(id);
		
	}
	private void studentAdd(HttpServletRequest request, HttpServletResponse response, StudentService studentService) {
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		studentService.addStu(name,ageStr);
	}
	private void studentList(HttpServletRequest request, HttpServletResponse response, StudentService studentService) throws IOException {
		String pageNumStr = request.getParameter("pageNum");
		String countStr = request.getParameter("count");
		Map<String, Object> map = studentService.getAll(pageNumStr,countStr);
		PageNumber pu = (PageNumber) map.get("pu");
		StringBuffer buffer = new StringBuffer();
		//{"pu":{"pageCount":?,"pageNum":?,"pageSize":?,"pageSum":?},}
		buffer.append("{\"pu\":{\"pageCount\":");
		buffer.append(pu.getPageCount());
		buffer.append(",\"pageNum\":");
		buffer.append(pu.getPageNum());
		buffer.append(",\"pageSize\":");
		buffer.append(pu.getPageSize());
		buffer.append(",\"pageSum\":");
		buffer.append(pu.getPageSum());
		buffer.append("},\"slist\":[");
		List<Students> slist = (List<Students>) map.get("slist");
		//{"slist":[{"id":"?","name":"?","age":?}]}
		
		for(int i= 0;i<slist.size();i++){
			Students s = slist.get(i);
			buffer.append("{\"id\":\"");
			buffer.append(s.getId());
			buffer.append("\",\"name\":\"");
			buffer.append(s.getName());
			buffer.append("\",\"age\":");
			buffer.append(s.getAge());
			buffer.append("}");
			if(i<slist.size()-1){
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
