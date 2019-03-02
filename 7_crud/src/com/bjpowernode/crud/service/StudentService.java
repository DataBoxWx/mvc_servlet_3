package com.bjpowernode.crud.service;

import java.util.Map;

import com.bjpowernode.crud.domain.Student;

public interface StudentService {

	Map<String,Object> getAll(String pageNoStr);

	void save(Student s);

	Student getStuById(String id);

	void update(Student s);

	void delete(String id);

}
