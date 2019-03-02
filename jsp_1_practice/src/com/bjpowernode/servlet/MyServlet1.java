package com.bjpowernode.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.domain.Students;

public class MyServlet1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("str1", "aa");
		String[] arr = {"aa","bb","cc"};
		request.setAttribute("str2", arr);
		List<String> list = new ArrayList<>();
		list.add("ab");
		list.add("bc");
		list.add("cd");
		request.setAttribute("str3", list);
		Map<String,String> map = new HashMap<>();
		map.put("str_1", "11");
		map.put("str_2", "22");
		request.setAttribute("str4", map);
		Students stu = new Students("id","小小",13,'男');
		request.setAttribute("stu", stu);
		request.getRequestDispatcher("/jsp/el.jsp").forward(request, response);;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
