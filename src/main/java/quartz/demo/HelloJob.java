package quartz.demo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import timer.demo.tt;
import util.StringCode;

public class HelloJob implements Job{

	//要运行的任务题，相当于timertask中的run方法
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("job运行了"+StringCode.getDateTime());
	}

}
