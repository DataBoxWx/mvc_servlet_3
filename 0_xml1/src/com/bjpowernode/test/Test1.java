package com.bjpowernode.test;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test1 {

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
		//取得元素名
		/*String name = root.getName();
		System.out.println(name);*/
		
		/*
		 * eList:表示从根元素下取得的一级子元素
		 * p1 p2 p3
		 */
		List<Element> eList = root.elements();
		
		//e 代表p1 p2 p3
		for(Element e:eList){
			
			/*String name = e.getName();
			System.out.println(name);*/
			
			//二级子元素 id name age
			List<Element> eeList = e.elements();
			for(Element ee:eeList){
				
				/*String name = ee.getName();
				System.out.println(name);*/
				
				String text = ee.getText();
				System.out.println(text);
				
			}
			System.out.println("--------------");
			
			
		}
		
		
	}

}















