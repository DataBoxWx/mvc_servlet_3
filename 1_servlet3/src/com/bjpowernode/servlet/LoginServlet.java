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

public class LoginServlet extends HttpServlet {
	
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
			
			/*PrintWriter out = response.getWriter();
			out.print("登录成功");
			out.close();*/
			
			/*
			 * 从数据库表中查询出所有学生信息
			 * 查询出来的信息打包成List<Student> sList
			 * 
			 * sList通过响应流展现在浏览器上
			 * 
			 */
			
			Connection conn1 = null;
			PreparedStatement ps1 = null;
			ResultSet rs1 = null;
			String sql1 = "select id,name,age from tbl_student";
			List<Student> sList = new ArrayList<Student>();
			
			try{
				conn1 = DBUtil.getConn();
				ps1 = conn1.prepareStatement(sql1);
				rs1 = ps1.executeQuery();
				
				while(rs1.next()){
					
					Student s = new Student();
					
					s.setId(rs1.getString(1));
					s.setName(rs1.getString(2));
					s.setAge(rs1.getInt(3));
					
					sList.add(s);
					
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				try {
					DBUtil.myClose(conn1, ps1, rs1);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			/*
			 * 以上为取得学生信息列表的过程
			 * 以下为通过响应流展现学生信息列表
			 */
			
			
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<body>");
			out.print("<table border='1'>");
			
			out.print("<tr>");
			out.print("<td>");
			out.print("序号");
			out.print("</td>");
			out.print("<td>");
			out.print("编号");
			out.print("</td>");
			out.print("<td>");
			out.print("姓名");
			out.print("</td>");
			out.print("<td>");
			out.print("年龄");
			out.print("</td>");
			out.print("</tr>");
			
			for(int i=0;i<sList.size();i++){
				
				//取得每一个学生
				Student s = sList.get(i);
				
				out.print("<tr>");
				out.print("<td>");
				out.print(i+1);
				out.print("</td>");
				out.print("<td>");
				out.print(s.getId());
				out.print("</td>");
				out.print("<td>");
				out.print(s.getName());
				out.print("</td>");
				out.print("<td>");
				out.print(s.getAge());
				out.print("</td>");
				out.print("</tr>");
				
				
			}
			
			
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");
			
			out.close();
			
			
			
			
			
			
		
		//登录失败
		}else{
			
			PrintWriter out = response.getWriter();
			out.print("登录失败");
			out.close();
			
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

























