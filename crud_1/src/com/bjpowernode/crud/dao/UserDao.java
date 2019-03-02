package com.bjpowernode.crud.dao;

public interface UserDao {

	int getCountByUsernameAndPassword(String username, String password);

}
