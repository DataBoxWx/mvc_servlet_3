package com.bjpowernode.domain;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public class Students {
	private String id;
	private String name;
	private int age;
	private char sex;
	public Students(){
		super();
	}
	public Students(String id, String name, int age, char sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	
}
