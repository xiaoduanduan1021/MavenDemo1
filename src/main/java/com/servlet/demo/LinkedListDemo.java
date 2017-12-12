package com.servlet.demo;

import java.util.LinkedList;

/**
 * 测试队列，先进先出功能
 * @author Administrator
 * poll方法每读取一个，列表内就会少一个，
 * 读取的是最先放入的且没被读取过的
 * 
 * 他还有别的方法读取不会被删除
 */
public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		//添加
		linkedList.add("老大");
		linkedList.add("老二");
		linkedList.add("老三");
		linkedList.add("老四");
		linkedList.add("老五");
		System.out.println(linkedList.size());
		
		System.out.println(linkedList.poll());
		System.out.println(linkedList.poll());
		
		linkedList.add("老6");
		linkedList.add("老7");
		
		System.out.println(linkedList.poll());
		System.out.println(linkedList.poll());
		System.out.println(linkedList.poll());
		
		linkedList.add("老8");
		
		System.out.println(linkedList.poll());
		System.out.println(linkedList.poll());
		System.out.println(linkedList.poll());
		System.out.println(linkedList.poll());
		
		System.out.println(linkedList.size());
	}
}
