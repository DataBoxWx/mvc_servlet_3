package com.bjpowernode.crud.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bjpowernode.crud.dao.StudentDao;
import com.bjpowernode.crud.dao.impl.StudentDaoImpl;
import com.bjpowernode.crud.domain.Student;
import com.bjpowernode.crud.service.StudentService;
import com.bjpowernode.crud.util.PageUtil;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao = new StudentDaoImpl();
	
	/*
	 * getAll方法
	 * 
	 * 参数:pageNoStr,拿着这个参数取当前页的学生信息列表
	 * 
	 * 返回值:
	 * List<Student> sList
	 * PageUtil pu
	 * 
	 * 需要返回以上两部分信息
	 * 我们最常用的做法是使用map
	 * 
	 * 创建一个map
	 * map.put("sList",sList)
	 * map.put("pu",pu)
	 * 由map来存储两部分信息
	 * 返回map就可以了
	 * 
	 * 
	 * 
	 */
	@Override
	public Map<String,Object> getAll(String pageNoStr) {
		
		//得到了需要显示学生信息列表的  页码
		int pageNo = 1;
		if(pageNoStr!=null && !"".equals(pageNoStr.trim())){
			
			pageNo = Integer.valueOf(pageNoStr);
			
		}
		
		//设置每页显示5条记录
		int pageCount = 5;
		
		//得到共多少条记录
		int total = studentDao.getTotal();
		
		
		//得到共多少页
		int pageSize = total/pageCount;
		if(total%pageCount>0){
			pageSize++;
		}
		
		PageUtil pu = new PageUtil();
		pu.setPageCount(pageCount);
		pu.setPageNo(pageNo);
		pu.setPageSize(pageSize);
		pu.setTotal(total);
		
		//以上就是得到了我们需要返回的第一部分信息  分页信息
		
		int skipCount = (pageNo-1)*pageCount;
		
		List<Student> sList = studentDao.getAll(skipCount, pageCount);
		
		//以上就是得到了我们需要返回的第二部分信息  当前页学生列表信息
		
		//两部分信息都得到了,接下来将两部分信息存储到map中,一起返回
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sList",sList);
		map.put("pu",pu);
		
		return map;
	}

	@Override
	public void save(Student s) {
		
		studentDao.save(s);
		
	}

	@Override
	public Student getStuById(String id) {
		
		Student s = studentDao.getStuById(id);
		
		return s;
	}

	@Override
	public void update(Student s) {
		
		studentDao.update(s);
		
	}

	@Override
	public void delete(String id) {
		
		studentDao.delete(id);
		
	}

}



























