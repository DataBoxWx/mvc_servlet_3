package com.bjpowernode.servlet_3_practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.bjpowernode.common.util.Jutil;
import com.bjpowernode.domain.Students;

public class Practice1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		String sql = "select count(*) from tbl_user where username=? and password = ?";
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet res = null;
		Boolean m = true;
		try {
			conn = Jutil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, password);
			res = ps.executeQuery();
			if(res.next()){
				int i = res.getInt(1);
				if(i != 1){
					m = false;
				}
			}
			
			if(m){
				List<Students> list = new ArrayList<Students>();
				String sql1 = "select id,name,age,sex from Student";
				ps = conn.prepareStatement(sql1);
				res = ps.executeQuery();
				while(res.next()){
					Students stu = new Students();
					stu.setName(res.getString("name"));
					stu.setAge(res.getInt("age"));
					stu.setSex(res.getString("sex").charAt(0));
					list.add(stu);
				}
				out.print("<html>");
				out.print("<body>");
				out.print("<table border='1'>");
				out.print("<tr>");
				out.print("<td>");
				out.print("±àºÅ");
				out.print("</td>");
				out.print("<td>");
				out.print("ÐÕÃû");
				out.print("</td>");
				out.print("<td>");
				out.print("ÄêÁä");
				out.print("</td>");
				out.print("<td>");
				out.print("ÐÔ±ð");
				out.print("</td>");
				out.print("</tr>");
				for(int i = 0;i < list.size();i++){
					out.print("<tr>");
					out.print("<td>");
					out.print(i+1);
					out.print("</td>");
					out.print("<td>");
					out.print(list.get(i).getName());
					out.print("</td>");
					out.print("<td>");
					out.print(list.get(i).getAge());
					out.print("</td>");
					out.print("<td>");
					out.print(list.get(i).getSex());
					out.print("</td>");
					out.print("</tr>");			
				}
				out.print("</table>");
				out.print("</body>");
				out.print("</html>");	
				
				
				
			}else {
				out.print("ÕË»§Ãû»òÃÜÂë´íÎó£¬µÇÂ¼Ê§°Ü");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Jutil.close1(conn, ps, res);
		}
		
		
}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
