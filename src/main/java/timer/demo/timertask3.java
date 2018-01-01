package timer.demo;

import java.util.TimerTask;

public class timertask3 extends TimerTask{

	String name;
	
	
	public timertask3(String name) {
		super();
		this.name = name;
	}


	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
