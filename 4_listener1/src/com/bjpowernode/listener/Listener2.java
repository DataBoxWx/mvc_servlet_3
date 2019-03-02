package com.bjpowernode.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class Listener2 implements ServletRequestListener{
	
	@Override
	public void requestInitialized(ServletRequestEvent event) {
		
		System.out.println("request对象创建了");
		
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		
		System.out.println("request对象销毁了");
		
	}
	
	
}

























