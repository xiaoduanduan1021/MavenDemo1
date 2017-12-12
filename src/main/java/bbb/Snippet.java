package bbb;

import com.servlet.demo.ArrayListDemo;

public class Snippet {
	public static void main(String[] args) throws InterruptedException {
			
			ArrayListDemo  arrayListDemo = new ArrayListDemo();
			
			for (int i = 0; i < 1000; i++) {
				new Thread(arrayListDemo).start();
			}

			System.out.println(ArrayListDemo.list.size());
		}
}

