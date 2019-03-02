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
import com.bjpowernode.domain.Province;
import com.bjpowernode.domain.Student;

public class ProvinceServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入servlet4");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select id,name from tbl_province";
		List<Province> plist = new ArrayList<>();
		try {
			conn = Jutil.getConnection();
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery();
			while(res.next()){
				Province pro = new Province();
				pro.setId(res.getInt(1));
				pro.setName(res.getString(2));
				plist.add(pro);
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
		buffer.append("{\"plist\":[");
		for(int i = 0;i < plist.size(); i++){
			Province pro = plist.get(i);
	//		buffer.append("{"plist":[{"id":""+plist.getId()+"","name":""+plist.getName()+""}]}");
			buffer.append("{\"id\":\"");
			buffer.append(pro.getId());
			buffer.append("\",\"name\":\"");
			buffer.append(pro.getName());
			buffer.append("\"}");
			if(i<plist.size()-1){
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
