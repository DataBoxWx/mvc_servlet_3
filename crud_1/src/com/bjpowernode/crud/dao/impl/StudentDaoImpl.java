package com.bjpowernode.crud.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bjpowernode.crud.util.JuuID;
import com.bjpowernode.crud.dao.StudentDao;
import com.bjpowernode.crud.domain.Students;
import com.bjpowernode.crud.util.Jutil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Students> getAll(int skipCount,int pageCount) {
		// TODO Auto-generated method stub
		List<Students> slist = new ArrayList<>();
		
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select id,name,age from student limit ?,?";
		try {
			conn = Jutil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, skipCount);
			ps.setInt(2, pageCount);
			res = ps.executeQuery();
			while(res.next()){
				Students stu = new Students();
				stu.setId(res.getString(1));
				stu.setName(res.getString(2));
				stu.setAge(res.getInt(3));
				slist.add(stu);
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
		return slist;
	}

	@Override
	public void addStudent(Students stu) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into student (id,name,age) values (?,?,?)";
		try {
			conn = Jutil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, JuuID.getIdd());
			ps.setString(2, stu.getName());
			ps.setInt(3, stu.getAge());
			int i = ps.executeUpdate();
			System.out.println(i);
			
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

	@Override
	public Students getStudentById(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select id,name,age from student where id=?";
		Students stu = new Students();
		try {
			conn = Jutil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			res = ps.executeQuery();
			if(res.next()){
				stu.setId(res.getString(1));
				stu.setName(res.getString(2));
				stu.setAge(res.getInt(3));
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
		return stu;
	}

	@Override
	public void updateStudent(Students stu) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update student set name=?,age=? where id=?";
		try {
			conn = Jutil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			ps.setString(3, stu.getId());
			int i = ps.executeUpdate();
			System.out.println(i);
			
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

	@Override
	public void deleteStudent(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from student where id=?";
		try {
			conn = Jutil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int i = ps.executeUpdate();
			System.out.println(i);
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

	@Override
	public int getNumber() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		int count = 0;
		String sql = "select count(*) from student";
		try {
			conn = Jutil.getConnection();
			ps = conn.prepareStatement(sql);
			res  = ps.executeQuery();
			if(res.next()){
				count = res.getInt(1);
				System.out.println(count);
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
		return count;
	}

}
