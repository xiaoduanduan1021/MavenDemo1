package bbb;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;


/**
 * 测试Arraylist的添加速度
 * @author Administrator
 *
 */
public class list {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		
		long timestart = new Date().getTime();
			for (int i = 0; i < 100000000; i++) {
				l.add("1234567889");
			}
		
		long timeend = new Date().getTime();
		System.out.println(timeend-timestart);
		
	}
	
	/**
	 * 如果想用hashmap存储key中放入自定义对象
	 * 那么自定义对象的需要重写hashcode方法和equals方法
	 * hashcode获取当前对象的hash值，该值为数值型，由jvm根据当前对象内存地址和计算机硬件计算得到，
	 * 相同对象的hash值一定相等，不同对象的hash值可能相等
	 * equals方法计算两个对象是否相等，计算的是内部属性是否相等，
	 * 两个相同的对象一定相等
	 * 两个不同对象，如果属性相等，那么也可以相等
	 */
	@Test
	public void test2(){
		Map m = new HashMap();
		
		User u = new User();
		u.setName("123");
		
		m.put(u, "1241111111");
		
		
		
		User u2 = new User();
		u2.setName("123");
		System.out.println(m.get(u2));
	}
	
	/**
	 * 原始数值运算
	 */
	@Test
	public void test3(){
		int n = 3;
		System.out.println(Integer.toBinaryString(n));
		n= n<<1;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(n);
		n= n>>1;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(n);
		n= n>>1;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(n);
	}
	/**
	 * 原始数值运算
	 */
	@Test
	public void test4(){
		int n = -1;
		System.out.println(Integer.toBinaryString(n));
		n= n>>>3;
		System.out.println(Integer.toBinaryString(n));
	}
	/**
	 * 原始数值运算
	 */
	@Test
	public void test5(){
		int n = -1;
		System.out.println(32&7);
		
		int i=0,j=1;
	    if(i++==3 & j++==3){
	    	
	    }
	    System.out.println("i="+i);
	    System.out.println("j="+j);
	}
	/**
	 * 原始数值运算
	 */
	@Test
	public void test7(){
		System.out.println(16&15);
	}
	/**
	 * 原始数值运算
	 */
	@Test
	public void test6(){
		for (int i = 0; i < 30; i++) {
			System.out.println(i);
			System.out.println(indexFor(i, 16));
			System.out.println("--------------------");
		}
	}
	/**
	 * 原始数值运算
	 */
	@Test
	public void test8(){
		for (int i = 0; i < 30; i++) {
			System.out.println(i);
			System.out.println(indexFor2(i, 15));
			System.out.println("--------------------");
		}
	}
	
	int indexFor(int h, int length) {  
        return h & (length-1);  
    }  
	int indexFor2(int h, int length) {  
		return h & length;  
	}  
	
	
	
	//测试linkedlist是否有序
	public void mm(){
	}
}
