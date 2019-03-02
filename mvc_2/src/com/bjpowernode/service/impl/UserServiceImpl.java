package com.bjpowernode.service.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.dao.impl.UserDaoImpl;
import com.bjpowernode.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	@Override
	public Boolean Flag(String username,String password) {
		int count  = userDao.getCount(username,password);
		Boolean flag = true;
		if(count !=1){
			flag = false;
		}
		return flag;
	}

}
