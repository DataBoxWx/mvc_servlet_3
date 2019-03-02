package com.bjpowernode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.util.Jutil;

public class UserDaoImpl implements UserDao {

	@Override
	public int getCount(String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select count(*) from tbl_user where username=? and password=?";
		int count = 0;
		try {
			conn = Jutil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			res = ps.executeQuery();
			while(res.next()){
				count = res.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return count;
	}

}
