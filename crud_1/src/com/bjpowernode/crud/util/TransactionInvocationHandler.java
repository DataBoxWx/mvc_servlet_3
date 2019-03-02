package com.bjpowernode.crud.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

import com.bjpowernode.crud.util.*;
import com.bjpowernode.crud.service.impl.*;

public class TransactionInvocationHandler implements InvocationHandler {
	private Object target;
	public TransactionInvocationHandler(Object target) {
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Connection conn = null;
		Object obj = null;
		try {
			conn = Jutil.getConnection();
			System.out.println(conn);
			conn.setAutoCommit(false);
			
			obj = method.invoke(target, args);
			
			conn.commit();
			
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}finally {
			Jutil.close1(conn, null, null);
		}
		
		return obj;
	}
	public Object getProxy() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

}
