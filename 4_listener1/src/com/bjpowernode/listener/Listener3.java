package com.bjpowernode.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Listener3 implements HttpSessionListener{
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		
		System.out.println("session对象创建了");
		
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		
		System.out.println("session对象销毁了");
		
	}
	
}

























