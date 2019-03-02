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

import com.bjpowernode.domain.Province;
import com.bjpowernode.util.DBUtil;

public class ProvinceListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到查询省份操作");
		
		response.setContentType("text/html;charset=utf-8");
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id,name from tbl_province";
		List<Province> pList = new ArrayList<Province>();
		
		try{
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				Province p = new Province();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				pList.add(p);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				DBUtil.myClose(conn, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//将pList翻译成json格式的字符串
		
		//{"pList":[{"id":?,"name":"?"},{},{}]}
		
		StringBuffer buf = new StringBuffer();
		buf.append("{\"pList\":[");
		
		for(int i=0;i<pList.size();i++){
			
			Province p = pList.get(i);
			
			//buf.append("{\"id\":"+p.getId()+",\"name\":\""+p.getName()+"\"}");
			
			buf.append("{\"id\":");
			buf.append(p.getId());
			buf.append(",\"name\":\"");
			buf.append(p.getName());
			buf.append("\"}");
			
			if(i<pList.size()-1){
				
				buf.append(",");
				
			}
			
		}
		
		buf.append("]}");
		
		System.out.println(buf.toString());
		
		PrintWriter out = response.getWriter();
		out.print(buf.toString());
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入到doPost方法");
		this.doGet(request, response);
	}

}























