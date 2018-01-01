package timer.demo;

import java.util.TimerTask;

public class timertask extends TimerTask{

	String name = "";
	
	
	public timertask(String name) {
		super();
		this.name = name;
	}
	public timertask() {
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("运行了"+name);
		System.out.println("下次计划执行时间"+new tt().sdf.format(scheduledExecutionTime()));
	}

	
}
