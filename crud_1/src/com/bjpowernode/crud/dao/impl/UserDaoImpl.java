package com.bjpowernode.crud.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bjpowernode.crud.util.Jutil;
import com.bjpowernode.crud.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public int getCountByUsernameAndPassword(String username, String password) {
		Connection  conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		int count = 0;
		String sql = "select count(*) from tbl_user where username=? and password=?";
		try {
			conn = Jutil.getConnection();
			System.out.println(conn);
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			res  = ps.executeQuery();
			while(res.next()){
				 count = res.getInt(1);
			}
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			Jutil.close1(null, ps, res);
		}
		return count;
		
		
	}

}
