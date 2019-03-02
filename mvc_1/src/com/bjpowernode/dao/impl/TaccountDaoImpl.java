package com.bjpowernode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjpowernode.common.Jutil;
import com.bjpowernode.dao.TaccountDao;

public class TaccountDaoImpl implements TaccountDao {

	@Override
	public Boolean checkAccount(String account) {
		Connection  conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		Boolean flag = true;
		String sql = "select count(*) from tbl_account where account=?";
		try {
			conn = Jutil.getConnection();
			System.out.println(conn);
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			res  = ps.executeQuery();
			while(res.next()){
				int i = res.getInt(1);
				if(i != 1){
					flag = false;
				}
			}
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			Jutil.close1(null, ps, res);
		}
		return flag;
	}

	@Override
	public int getBalanceByAccount(String account) {
		Connection  conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select balance from tbl_account where account=?";
		int balance = 0;
		try {
			conn = Jutil.getConnection();
			System.out.println(conn);
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			res  = ps.executeQuery();
			while(res.next()){
				balance =res.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			Jutil.close1(null, ps, res);
		}
		return balance;
	}

	@Override
	public void updateBalanceByAccount(String account, int balance) {
		Connection  conn = null;
		PreparedStatement ps = null;
		String sql = "update tbl_account set balance=? where account=?";
		try {
			conn = Jutil.getConnection();
			System.out.println(conn);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, balance);
			ps.setString(2, account);
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			Jutil.close1(null, ps, null);
		}

	}

}
