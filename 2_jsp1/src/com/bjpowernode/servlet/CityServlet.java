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
import com.bjpowernode.domain.City;
import com.bjpowernode.domain.Province;
import com.bjpowernode.domain.Student;

public class CityServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入cityservlet");
		String pidString = request.getParameter("pid");
		System.out.println(pidString);
		int pid = Integer.valueOf(pidString);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select id,name from tbl_city where pid=?";
		List<City> clist = new ArrayList<>();
		try {
			conn = Jutil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			res = ps.executeQuery();
			while(res.next()){
				City city = new City();
				city.setId(res.getInt(1));
				city.setName(res.getString(2));
				clist.add(city);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer buffer = new StringBuffer();
		//{"plist":[{"id":"?"},]}
		buffer.append("{\"clist\":[");
		for(int i = 0;i < clist.size(); i++){
			City city = clist.get(i);
	//		buffer.append("{"plist":[{"id":""+plist.getId()+"","name":""+plist.getName()+""}]}");
			buffer.append("{\"id\":\"");
			buffer.append(city.getId());
			buffer.append("\",\"name\":\"");
			buffer.append(city.getName());
			buffer.append("\"}");
			if(i<clist.size()-1){
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
