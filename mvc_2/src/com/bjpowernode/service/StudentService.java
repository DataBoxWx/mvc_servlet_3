package com.bjpowernode.service;

import java.util.Map;

import com.bjpowernode.domain.Students;

public interface StudentService {

	Map<String, Object> getAll(String pageNumStr,String countStr);

	void addStu(String name, String ageStr);

	Students getStu(String id);

	void update(String id, String name, String ageStr);

	void delete(String id);

}
