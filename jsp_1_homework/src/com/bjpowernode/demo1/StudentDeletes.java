package com.bjpowernode.demo1;

import java.io.IOException;
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

import com.bjpowernode.common.JUUID;
import com.bjpowernode.common.Jutil;
import com.bjpowernode.domain.Student;


public class StudentDeletes extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入到");
		String [] ids = request.getParameterValues("id");
		Connection conn = null;
		PreparedStatement ps = null;
	
		String sql = "delete from student where id=?";

		try { 
			conn = Jutil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			/*for (String id:ids) {
				ps.setString(1, id);
				int i = ps.executeUpdate();	
				System.out.println(i);
			}*/
			for(int i = 0;i<ids.length;i++){
				ps.setString(1, ids[i]);
				int s = ps.executeUpdate();	
				System.out.println(s);
			}
			conn.commit();
		} catch (ClassNotFoundException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Jutil.close1(conn, ps, null);
		}
		response.sendRedirect(request.getContextPath() + "/studentlist.do");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
