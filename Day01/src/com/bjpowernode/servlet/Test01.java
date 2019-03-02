package com.bjpowernode.servlet;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Test01 {

	public static void main(String[] args) throws DocumentException {
		SAXReader reader=new SAXReader();
		Document read = reader.read("src/com/bjpowernode/xml/person.xml");
		Element rootElement = read.getRootElement();
		System.out.println(rootElement.getName());
		List<Element> elements = rootElement.elements();
		for (Element o : elements) {
			List<Element> elements2 = o.elements();
			for (Element e : elements2) {
				System.out.println(e.getText());
			}
			System.out.println("***********");			
		}
		Element selectSingleNode = (Element) rootElement.selectSingleNode("//p3/id");
		System.out.println(selectSingleNode.getText());
		

	}

}
