package com.bjpowernode.crud.service.impl;

import com.bjpowernode.crud.dao.UserDao;
import com.bjpowernode.crud.dao.impl.UserDaoImpl;
import com.bjpowernode.crud.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public boolean login(String username, String password) {
		
		int count = userDao.login(username,password);
		
		boolean flag = true;
		if(count!=1){
			flag = false;
		}
		
		return flag;
	}

}




























