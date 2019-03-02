package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.util.DBUtil;

public class CheckUsernameServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到检查用户名是否重复的操作");
		
		//接收需要验证的用户名
		String username = request.getParameter("username");
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from tbl_user where username=?";
		boolean flag = true;
		
		try{
			
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				int count = rs.getInt(1);
				
				if(count!=0){
					flag = false;
				}
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				DBUtil.myClose(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		String str = null;
		
		if(flag){
			str = "a";
		}else{
			str = "b";
		}
		
		
		
		PrintWriter out = response.getWriter();
		out.print(str);
		out.close();
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入到doPost方法");
		this.doGet(request, response);
	}

}
























