package com.bjpowernode.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.impl.StudentDaoImpl;
import com.bjpowernode.domain.Students;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.util.PageNumber;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao = new StudentDaoImpl();
	@Override
	public Map<String, Object> getAll(String pageNumStr,String countStr) {
		int pageNum = Integer.valueOf(pageNumStr);//当前页
		int count = Integer.valueOf(countStr);//每页显示多少条
		/* pageCount = 0;//总条数&
		 pageNum = 1; //当前页&
		 pageSize = 0;//几条/页
		 pageSum=0;//总页数
		 count = 1;//设置每页显示数量
*/		int pageCount = studentDao.getSize();
		int pageSum =pageCount/count;
		if(pageCount%count!=0){
			pageSum += 1;
		}

		int pageSize = count;
		if(pageNum == pageSum ){
			pageSize = pageCount-(pageSum-1)*count;
		}
		int skipCount = (pageNum-1)*count;
		
		PageNumber pu =new PageNumber(pageCount, pageNum, pageSize, pageSum);
		
		List<Students> sList= studentDao.getAll(skipCount,count);
		Map<String, Object> map =new HashMap<>();
		map.put("slist", sList);
		map.put("pu", pu);
		return map;
	}
	@Override
	public void addStu(String name, String ageStr) {
		int age = Integer.valueOf(ageStr);
		studentDao.addStu(name,age);
	}
	@Override
	public Students getStu(String id) {
		Students stu = studentDao.getStu(id);
		return stu;
	}
	@Override
	public void update(String id, String name, String ageStr) {
		int age = Integer.valueOf(ageStr);
		studentDao.update(id,name,age);
		
	}
	@Override
	public void delete(String id) {
		studentDao.delete(id);
		
	}

}
