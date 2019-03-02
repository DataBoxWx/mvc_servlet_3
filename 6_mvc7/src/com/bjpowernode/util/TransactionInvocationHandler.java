package com.bjpowernode.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionInvocationHandler implements InvocationHandler{
	
	//zs
	private Object target;
	
	public TransactionInvocationHandler(Object target){
		this.target = target;
	}
	
	
	/*
	 * 该方法为ls的送花方法(代理类的增强方法)
	 * 
	 * 两部分代码组成
	 * 
	 * 
	 * 业务逻辑 由zs来完成业务逻辑
	 * zs:target
	 * 业务逻辑方法:就是参数method
	 * 
	 * zs也有了,方法也有了,接下来我们要做的是,使用zs去调用方法
	 * 怎么调???
	 * 
	 * 
	 * 
	 * 增强代码 事务
	 * 
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Connection conn = null;
		Object obj = null;
		
		try{
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			
			
			obj = method.invoke(target, args);
			
			
			
			conn.commit();
		}catch(Exception e){
			conn.rollback();
			e.printStackTrace();
		}finally{
			DBUtil.myClose(conn,null,null);
		}
		
		
		return obj;
	}
	
	
	/*
	 * 创建动态代理类的对象
	 * 创建ls对象
	 */
	public Object getProxy(){
		
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
		
	}
	
	
	
}











































