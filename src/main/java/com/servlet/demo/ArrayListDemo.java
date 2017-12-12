package com.servlet.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 测试arraylist多线程下安全问题
 * @author Administrator
 *
 */
public class ArrayListDemo implements Runnable{

	public static List<Integer> list = new ArrayList<Integer>();
//	public static List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
	public static Object suo = 1;
	
	public void run() {
			for (int i = 0; i < 100; i++) {
				list.add(i);
				System.out.println(Thread.currentThread().getName());
			}
	}

	
	
}
	
