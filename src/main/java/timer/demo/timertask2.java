package timer.demo;

import java.util.Date;
import java.util.TimerTask;

public class timertask2 extends TimerTask{

	public static int i = 0;
	@Override
	public void run() {
		System.out.println(new Date().getTime()/1000);
		System.out.println("运行第"+i+"次");
		if (i==2) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		i++;
		
		if (i==5) {
			cancel();//关闭当前任务
			System.out.println("达到4关闭");
		}
	}
}
