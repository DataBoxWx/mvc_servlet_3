package com.bjpowernode.crud.dao;

import java.util.List;
import java.util.Map;

import com.bjpowernode.crud.domain.Students;

public interface StudentDao {

	List<Students> getAll(int skipCount,int pageCount);

	void addStudent(Students stu);

	Students getStudentById(String id);

	void updateStudent(Students stu);

	void deleteStudent(String id);

	int getNumber();

}
