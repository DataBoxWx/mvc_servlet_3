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

import com.bjpowernode.domain.Student;
import com.bjpowernode.util.DBUtil;

public class StudentDeletesServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到删除学生操作 可批量删除");
		
		
		
		/*
		 * 事务
		 * 
		 * 转账
		 * t_account
		 * 
		 * id    account     balance
		 * 1       zs         2000
		 * 2       ls         2000
		 * 
		 * zs给ls转500块钱
		 * 
		 * 
		 * 
		 */
		
		//接收需要删除记录的id
		//String id = request.getParameter("id");
		
		String ids[] = request.getParameterValues("id");
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from tbl_student where id=?";
		
		try{
			conn = DBUtil.getConn();
			
			//将jdbc中的事务修改为手动提交   开启一个事务
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(sql);
			
			for(String id:ids){
				ps.setString(1,id);
				ps.executeUpdate();
			}
			
			conn.commit();
			
		}catch(SQLException e){
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}finally{
			try {
				DBUtil.myClose(conn, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * 以上是完成了删除的操作
		 * 以下是完成删除后,应该跳转到学生列表操作 student/list.do
		 * 
		 * 转发还是重定向?
		 * 
		 * 转发:
		 * student/delete.do
		 * 
		 * 重定向:
		 * student/list.do
		 * 
		 */
		
		response.sendRedirect(request.getContextPath() + "/student/list.do");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

























