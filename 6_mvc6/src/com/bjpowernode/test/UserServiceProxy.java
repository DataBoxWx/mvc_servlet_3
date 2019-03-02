package com.bjpowernode.test;

public class UserServiceProxy implements UserService {

	private UserServiceImpl usi;
	
	public UserServiceProxy(UserServiceImpl usi){
		
		this.usi = usi;
		
	}
	
	@Override
	public void save() {
		
		System.out.println("执行添加人员操作--记录日志开始");
		usi.save();
		System.out.println("执行添加人员操作--记录日志结束");
	}

	@Override
	public void delete() {
		

	}

	@Override
	public void update() {
		

	}

	@Override
	public void select() {
		

	}

}
