package com.bjpowernode.crud.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class TransactionInvocationHandler implements InvocationHandler{

	private Object target;
	
	public TransactionInvocationHandler(Object target){
		this.target = target;
	}
	
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
			DBUtil.myClose(conn, null, null);
		}
		
		
		return obj;
	}
	
	public Object getProxy(){
		
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
		
	}
	

}



























