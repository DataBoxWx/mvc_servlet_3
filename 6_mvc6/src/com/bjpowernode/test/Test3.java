package com.bjpowernode.test;

import java.lang.reflect.Method;

public class Test3 {

	public static void main(String[] args) throws Exception {
		
		Class c = Class.forName("com.bjpowernode.test.Person");
		
		Person p = new Person();
		/*
		 * 参数1:方法名
		 * 参数2:方法参数的反射类型对象
		 */
		
		//m相当于say方法
		Method m = c.getMethod("say");
		
		//如何执行m
		/*
		 * 使用Method.invoke来执行方法
		 * 参数1:我们要调用该方法的对象
		 * 参数2:传递到这个方法中的实参
		 */
		m.invoke(p);

	}

}























