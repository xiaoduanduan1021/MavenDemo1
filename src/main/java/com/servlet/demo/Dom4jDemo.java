package com.servlet.demo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


/**
 * xml字符串转换成document文档并获取值
 * @author Administrator
 *
 */
public class Dom4jDemo {

	
	public static void main(String[] args) throws DocumentException {
		System.out.println("开始");
		StringBuilder s = new StringBuilder();
		s.append("<person>");
			s.append("<name>");
				s.append("Jnames段");
			s.append("</name>");
			s.append("<age>");
				s.append("男");
			s.append("</age>");
		s.append("</person>");
		Document document = DocumentHelper.parseText(s.toString());
		Element element = document.getRootElement();
		Element zi = element.element("name");
		String zicontent = zi.getText();
		System.out.println(zicontent);
	}
}
