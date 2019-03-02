package com.bjpowernode.test;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Test2 {

	public static void main(String[] args) throws Exception {
		
		/*
		 * reader:阅读器
		 */
		SAXReader reader = new SAXReader();
		
		/*
		 * doc:表示的就是我们要解析的person.xml文档
		 */
		Document doc = reader.read("src/com/bjpowernode/xml/person.xml");
		
		//root此时就代表Person元素(根元素)
		Element root = doc.getRootElement();
		
		Element e = (Element)root.selectSingleNode("//p1/name");
		
		String text = e.getText();
		System.out.println(text);
		
		/*
		 * 总结:以上形式为解析xml的xpath(取得元素的路径由我们自己来指定)形式,这种形式可以快速的定位到某一个指定的元素
		 * 
		 * 在实际项目开发中:
		 * 1.如果项目的需求是将xml文件中所有的元素取得,那么我们可以使用传统的形式dom4j的形式 见Test1.java
		 * 2.如果项目的需求是快速的指定某一个单个元素,那么我们使用xpath的形式比较方便
		 * 
		 * 
		 * 注意:
		 * 1.使用xpath的形式,必须要导入jaxen-1.1-beta-6.jar才可以
		 * 2.xpath的形式是传统dom4j形式的扩充,不能独立存在
		 * 		也就是说只有jaxen-1.1-beta-6.jar是不能够进行解析的,必须得搭配dom4j来使用
		 * 		这是一种依赖关系,xpath的形式依赖于我们传统的dom4j的形式
		 * 
		 * 
		 */
		
		
	}

}















