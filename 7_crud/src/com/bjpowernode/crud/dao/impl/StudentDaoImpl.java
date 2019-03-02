package com.bjpowernode.crud.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjpowernode.crud.dao.StudentDao;
import com.bjpowernode.crud.domain.Student;
import com.bjpowernode.crud.util.DBUtil;
import com.bjpowernode.crud.util.UUIDUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> getAll(int skipCount,int pageCount) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id,name,age from tbl_student limit ?,?";
		List<Student> sList = new ArrayList<Student>();
		
		try{
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,skipCount);
			ps.setInt(2,pageCount);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				Student s = new Student();
				
				s.setId(rs.getString(1));
				s.setName(rs.getString(2));
				s.setAge(rs.getInt(3));
				
				sList.add(s);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			try {
				DBUtil.myClose(null, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return sList;
	}

	@Override
	public int getTotal() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from tbl_student";
		int count = 0;
		
		try{
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				count = rs.getInt(1);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			try {
				DBUtil.myClose(null, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return count;
	}

	@Override
	public void save(Student s) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into tbl_student(id,name,age) values(?,?,?)";
		
		try{
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,UUIDUtil.getUUID());
			ps.setString(2,s.getName());
			ps.setInt(3,s.getAge());
			
			ps.executeUpdate();
			
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			try {
				DBUtil.myClose(null, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Student getStuById(String id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select name,age from tbl_student where id=?";
		Student s = new Student();
		
		try{
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				s.setId(id);
				s.setName(rs.getString(1));
				s.setAge(rs.getInt(2));
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			try {
				DBUtil.myClose(null, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return s;
	}

	@Override
	public void update(Student s) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update tbl_student set name=?,age=? where id=?";
		
		try{
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,s.getName());
			ps.setInt(2,s.getAge());
			ps.setString(3,s.getId());
			
			ps.executeUpdate();
			
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			try {
				DBUtil.myClose(null, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void delete(String id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from tbl_student where id=?";
		
		try{
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			
			ps.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			try {
				DBUtil.myClose(null, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}

























