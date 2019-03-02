package com.bjpowernode.test;

import java.lang.reflect.Method;

public class Test4 {

	public static void main(String[] args) throws Exception {
		
		Class c = Class.forName("com.bjpowernode.test.Person");
		
		Person p = new Person();
		
		//m代表add方法
		Method m = c.getMethod("add",int.class,int.class,String.class);

		String str = (String)m.invoke(p,1,2,"两个数字的和为:");
		
		System.out.println(str);
		
	}

}























