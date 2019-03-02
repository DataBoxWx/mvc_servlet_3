package com.bjpowernode.test;

import java.util.UUID;

public class Test1 {

	public static void main(String[] args) {
		
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		
		str = str.replaceAll("-","");
		
		System.out.println(str);
		System.out.println(str.length());
		
		/*
		 * 1.uuid会重复吗?
		 * 不会
		 * 
		 * 2.uuid的表结构的类型应该是什么?
		 * varchar(32) 变长 "aaa"
		 * char(32) 定长 "aaa                       "
		 * 使用char(32)
		 * 
		 * 
		 * 3.为什么要用uuid
		 * 如果涉及到数据库移植,uuid的可维护性更强
		 * 
		 */

	}

}










