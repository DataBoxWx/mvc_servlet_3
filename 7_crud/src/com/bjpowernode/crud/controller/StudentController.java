package com.bjpowernode.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.crud.domain.Student;
import com.bjpowernode.crud.service.StudentService;
import com.bjpowernode.crud.service.impl.StudentServiceImpl;
import com.bjpowernode.crud.util.PageUtil;
import com.bjpowernode.crud.util.ServiceFactory;

public class StudentController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到学生操作模块");
		
		//判断请求是什么?根据发出的请求的路径来做判断 就是url-pattern
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String path = request.getServletPath();
		
		StudentService studentService = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
		
		if("/student/list.do".equals(path)){
			
			list(request,response,studentService);
			
		}else if("/student/save.do".equals(path)){
			
			save(request,response,studentService);
			
		}else if("/student/edit.do".equals(path)){
			
			edit(request,response,studentService);
			
		}else if("/student/update.do".equals(path)){
			
			update(request,response,studentService);
			
		}else if("/student/delete.do".equals(path)){
			
			delete(request,response,studentService);
			
		}
		
		
		
		
		
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response, StudentService studentService) throws ServletException, IOException {
		
		System.out.println("进入到学生信息列表操作");
		
		String pageNoStr = request.getParameter("pageNo");
		
		Map<String,Object> map = studentService.getAll(pageNoStr);
		
		//从map中取得两部分信息
		PageUtil pu = (PageUtil)map.get("pu");
		List<Student> sList = (List<Student>)map.get("sList");
		
		//{"sList":[{"id":"?","name":"?","age":?},{},{}]}
		
		//{"pu":{"pageNo":?,"pageCount":?,"pageSize":?,"total":?},"sList":[{"id":"?","name":"?","age":?},{},{}]}
		
		StringBuffer buf = new StringBuffer();
		//buf.append("{\"sList\":[");
		
		
		/*buf.append("{\"pu\":{\"pageNo\":"+pu.getPageNo()+",\"pageCount\":"+
		pu.getPageCount()+",\"pageSize\":"+pu.getPageSize()+",\"total\":"+pu.getTotal()+"},\"sList\":[");*/
		
		buf.append("{\"pu\":{\"pageNo\":");
		buf.append(pu.getPageNo());
		buf.append(",\"pageCount\":");
		buf.append(pu.getPageCount());
		buf.append(",\"pageSize\":");
		buf.append(pu.getPageSize());
		buf.append(",\"total\":");
		buf.append(pu.getTotal());
		buf.append("},\"sList\":[");
		
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
		
		System.out.println(buf.toString());
		
		PrintWriter out = response.getWriter();
		out.print(buf.toString());
		out.close();
		
		
	}

	private void save(HttpServletRequest request, HttpServletResponse response, StudentService studentService) throws ServletException, IOException {
		
		System.out.println("进入到添加学员操作");
		
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		int age = Integer.valueOf(ageStr);
		
		Student s = new Student();
		s.setName(name);
		s.setAge(age);
		
		studentService.save(s);
		
		response.sendRedirect(request.getContextPath() + "/jsp/student/index.jsp");
		
	}

	private void edit(HttpServletRequest request, HttpServletResponse response, StudentService studentService) throws ServletException, IOException {
		
		System.out.println("进入到跳转到编辑页的相关操作   根据id取单条s");
		
		//接收id
		String id = request.getParameter("id");
		
		Student s = studentService.getStuById(id);
		
		//{"id":"?","name":"?","age":?}
		
		String str = "{\"id\":\""+s.getId()+"\",\"name\":\""+s.getName()+"\",\"age\":"+s.getAge()+"}";
		
		System.out.println(str);
		
		PrintWriter out = response.getWriter();
		out.print(str);
		out.close();
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response, StudentService studentService) throws ServletException, IOException {
		
		System.out.println("进入到修改学员操作");
		
		//接收表单参数
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		int age = Integer.valueOf(ageStr);
		
		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setAge(age);
		
		studentService.update(s);
		
		response.sendRedirect(request.getContextPath() + "/jsp/student/index.jsp");
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response, StudentService studentService) throws ServletException, IOException {
		
		System.out.println("执行删除操作");
		
		String id = request.getParameter("id");
		
		studentService.delete(id);
		
		response.sendRedirect(request.getContextPath() + "/jsp/student/index.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}
	
}





























