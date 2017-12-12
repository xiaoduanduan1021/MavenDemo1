package com.servlet.demo;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class CreateXml {

	public static void main(String[] args) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("persen");
		Element name = root.addElement("name");
		name.setText("小段段");
		Element age = root.addElement("age");
		age.setText("男");
		String s = document.asXML();
		System.out.println(s);
	}
}
