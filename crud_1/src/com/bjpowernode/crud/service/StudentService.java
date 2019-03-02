package com.bjpowernode.crud.service;

import java.util.List;
import java.util.Map;

import com.bjpowernode.crud.domain.Students;

public interface StudentService {

	Map<String,Object> getAll(String pageNu);

	void addStudent(Students stu);

	Students getStudentById(String id);

	void updateStudent(Students stu);

	void deleteStudent(String id);

}
