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

import com.bjpowernode.domain.City;
import com.bjpowernode.domain.Province;
import com.bjpowernode.util.DBUtil;

public class CityListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到查询城市操作");
		
		response.setContentType("text/html;charset=utf-8");
		
		String pidStr = request.getParameter("pid");
		int pid = Integer.valueOf(pidStr);
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id,name from tbl_city where pid=?";
		List<City> cList = new ArrayList<City>();
		
		try{
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,pid);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				City c = new City();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				cList.add(c);
				
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
		
		
		//将cList翻译成json格式的字符串
		
		//{"cList":[{"id":?,"name":"?"},{},{}]}
		
		StringBuffer buf = new StringBuffer();
		buf.append("{\"cList\":[");
		
		for(int i=0;i<cList.size();i++){
			
			City c = cList.get(i);
			
			//buf.append("{\"id\":"+p.getId()+",\"name\":\""+p.getName()+"\"}");
			
			buf.append("{\"id\":");
			buf.append(c.getId());
			buf.append(",\"name\":\"");
			buf.append(c.getName());
			buf.append("\"}");
			
			if(i<cList.size()-1){
				
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









