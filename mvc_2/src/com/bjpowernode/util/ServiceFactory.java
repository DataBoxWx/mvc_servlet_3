package com.bjpowernode.util;

public class ServiceFactory {
	public static Object getProxy(Object target){
		return new TransactionInvocationHandler(target).getProxy();
	}
}
