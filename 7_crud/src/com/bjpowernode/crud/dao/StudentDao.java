package com.bjpowernode.crud.dao;

import java.util.List;

import com.bjpowernode.crud.domain.Student;

public interface StudentDao {

	List<Student> getAll(int skipCount,int pageCount);

	int getTotal();

	void save(Student s);

	Student getStuById(String id);

	void update(Student s);

	void delete(String id);

}
