package com.bjpowernode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.domain.Student;
import com.bjpowernode.util.DBUtil;

public class LoginServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		
		int count = 0;
		this.getServletContext().setAttribute("count",count);
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到登录操作");
		
		response.setContentType("text/html;charset=utf-8");
		
		//接收表单参数 用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		/*
		 * 1.声明所需变量
		 * 2.搭建try catch finally 结构
		 * 3.填充代码
		 */
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from tbl_user where username=? and password=?";
		boolean flag = true;
		
		try{
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			/*
			 * ps创建完之后,养成习惯,观察你的sql语句,如果有?,需要使用ps对?进行赋值
			 */
			ps.setString(1,username);
			ps.setString(2,password);
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				int count = rs.getInt(1);
				/*
				 * count:0 没有查询到记录 登录失败
				 * count:1 查询到了相应的用户名密码 登录成功
				 * count:>1 表中有垃圾数据 登录失败
				 */
				
				if(count!=1){
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
		
		//登录成功
		if(flag){
			
			/*
			 * 登录成功后,从上下文域中取出count+1
			 */
			int count = (Integer)this.getServletContext().getAttribute("count");
			
			count++;
			
			this.getServletContext().setAttribute("count",count);
			
			
			/*
			 * 登录成功后,跳转到学生信息列表
			 * 使用转发还是重定向?
			 * 
			 * 转发
			 * http://localhost:8080/1_servlet6/login.do
			 * 
			 * 重定向
			 * http://localhost:8080/1_servlet6/student/list.do
			 * 
			 */
			
			//request.getRequestDispatcher("/student/list.do").forward(request, response);
			response.sendRedirect("/1_servlet6/student/list.do");
			
			
			
			
			
		
		//登录失败
		}else{
			
			/*PrintWriter out = response.getWriter();
			out.print("登录失败");
			out.close();*/
			
			//失败实现方式1
			/*response.setHeader("refresh","3;url=/1_servlet6/login.html");
			PrintWriter out = response.getWriter();
			out.write("<html>");
			out.write("<body>");
			out.write("3秒钟之后，跳转到登录页");
			out.write("</body>");
			out.write("</html>");*/

			
			//失败实现方式2
			//response.sendRedirect("/1_servlet6/fail.html");
			
			
			//失败实现方式3
			/*
			 * 登录失败后,直接跳转到登录页
			 * 
			 * 使用转发还是重定向?
			 * 
			 * 转发后的路径
			 * http://localhost:8080/1_servlet6/login.do
			 * 
			 * 重定向后的路径
			 * http://localhost:8080/1_servlet6/login.html
			 * 
			 * 
			 * 未来的实际项目开发,使用转发还是使用重定向,取决于我们的页面能否正确执行刷新操作
			 * 对于该需求,我们想要刷的是登录页,而不是登录操作
			 * 所以说我们用重定向技术
			 * 
			 * 
			 */
			//request.getRequestDispatcher("/login.html").forward(request, response);
			response.sendRedirect("/1_servlet6/login.html");
			
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

























