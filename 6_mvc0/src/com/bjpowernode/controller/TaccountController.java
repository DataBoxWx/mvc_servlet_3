package com.bjpowernode.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.util.DBUtil;

import sun.security.pkcs11.Secmod.DbMode;

public class TaccountController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到转账操作");
		
		String zcAccount = request.getParameter("zcAccount");
		String zrAccount = request.getParameter("zrAccount");
		String zzBalanceStr = request.getParameter("zzBalance");
		int zzBalance = Integer.valueOf(zzBalanceStr);
		
		//1.判断转出账号有没有
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from t_account where account=?";
		boolean flag = true;
		
		try{
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,zcAccount);
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				int count = rs.getInt(1);
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
		
		if(flag){
			
			//2.判断转入账号有没有
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select count(*) from t_account where account=?";
			boolean flag = true;
			
			try{
				conn = DBUtil.getConn();
				ps = conn.prepareStatement(sql);
				ps.setString(1,zrAccount);
				rs = ps.executeQuery();
				
				if(rs.next()){
					
					int count = rs.getInt(1);
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
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

























