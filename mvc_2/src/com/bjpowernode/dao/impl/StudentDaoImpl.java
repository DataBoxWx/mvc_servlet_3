package com.bjpowernode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Students;
import com.bjpowernode.util.JUUID;
import com.bjpowernode.util.Jutil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Students> getAll(int skipCount,int count) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select id,name,age from student limit ?,?";
		List<Students> sList = new ArrayList<>();
		try {
			conn = Jutil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, skipCount);
			ps.setInt(2, count);
			res = ps.executeQuery();
			while(res.next()){
				Students s = new Students();
				s.setId(res.getString(1));
				s.setName(res.getString(2));
				s.setAge(res.getInt(3));
				sList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			Jutil.close1(null, ps, res);
		}
			
		return sList;
	}

	@Override
	public void addStu(String name, int age) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into student (id,name,age) values (?,?,?)";
		try {
			conn = Jutil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, JUUID.getId());
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			Jutil.close1(null, ps, null);
		}
		
	}

	@Override
	public Students getStu(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select name,age from student where id=?";
		Students s = new Students();
		try {
			conn = Jutil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			res = ps.executeQuery();
			
			if(res.next()){
				
				s.setName(res.getString(1));
				s.setAge(res.getInt(2));
				s.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			Jutil.close1(null, ps, res);
		}
		return s;
	}

	@Override
	public void update(String id, String name, int age) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update student set name=?,age=? where id=?";
		try {
			conn = Jutil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			Jutil.close1(null, ps, null);
		}
		
	}

	@Override
	public void delete(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from student where id=?";
		try {
			conn = Jutil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			Jutil.close1(null, ps, null);
		}
	}

	@Override
	public int getSize() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select count(*) from student";
		int count = 0;
		try {
			conn = Jutil.getConn();
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery();
			while(res.next()){
				count = res.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			Jutil.close1(null, ps, res);
		}
		return count;
	}

}
