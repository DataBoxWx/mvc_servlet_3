package com.bjpowernode.test;

public class UserServiceImpl implements UserService {

	@Override
	public void save() {
		
		System.out.println("执行添加操作");
		
		
	}

	@Override
	public void delete() {
		
		System.out.println("执行删除操作");
		
	}

	@Override
	public void update() {
		
		System.out.println("执行修改操作");

	}

	@Override
	public void select() {
		
		System.out.println("执行查询操作");

	}

}
