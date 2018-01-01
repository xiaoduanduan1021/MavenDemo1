package timer.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;


//测试timer的4种用法和2中特殊情况
public class tt {

	SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
//	第一种在指定时间后运行一次任务
	//3秒后运行,不会重复执行
	public void main1() {
		System.out.println("准备");
		Timer timer = new Timer();
		TimerTask timerTask = new timertask();
		timer.schedule(timerTask, 3000);
		System.out.println("当前时间"+sdf.format(new Date()));
		System.out.println("下次计划执行时间"+sdf.format(timerTask.scheduledExecutionTime()));
	}

	
	
	//	第二种在指定时间后运行任务然后每间隔指定时间运行一次，一直循环下去
	//3秒后开始运行,每个两秒重复执行1次
	@Test
	public void main2() {
		System.out.println("准备");
		Timer timer = new Timer();
		TimerTask timerTask = new timertask();
		timer.schedule(timerTask, 3000,2000);
		System.out.println("当前时间"+sdf.format(new Date()));
		System.out.println("下次计划执行时间"+sdf.format(timerTask.scheduledExecutionTime()));
	}
	//	第三种在指定时间运行任务运行一次
	//例如在2017年12月31日18:44:43运行
	@Test
	public void main3() throws ParseException {
		System.out.println("准备");
		Timer timer = new Timer();
		TimerTask timerTask = new timertask();
		Date date = sdf.parse("2017-12-31 18:46:15");
		timer.schedule(timerTask, date);
	}
	//	第4种在指定时间运行任务运行一次，然后每间隔指定毫秒再次运行
	//例如在2017年12月31日18:44:43运行每间隔1秒运行一次
	//这种方法比较常用，例如设置每天晚上12点运行程序，后面的毫秒需要输入24小时换算成毫秒的数字例如：24*60*60*1000，意思就是每间隔24小时运行一次
	@Test
	public void main4() throws ParseException {
		System.out.println("准备");
		Timer timer = new Timer();
		TimerTask timerTask = new timertask();
		Date date = sdf.parse("2017-12-31 18:50:30");
		timer.schedule(timerTask, date,1000);
	}
	
	//特殊情况
	
	//特殊情况1表现1
	//	当输入的开始执行时间早于当前时间时schedule方法会马上执行，然后再次间隔执行
	@Test
	public void main5() throws ParseException {
		System.out.println("准备");
		Timer timer = new Timer();
		TimerTask timerTask = new timertask();
		Date date = sdf.parse("2017-12-31 18:50:30");
		timer.schedule(timerTask, date,1000);
	}
	//特殊情况1表现2
	//	当输入的开始执行时间早于当前时间时scheduleAtFixedRate方法会马上执行,并且会执行多次补上运行时间与当前时间的间隔中应该运行的次数，然后再次间隔执行
	//如果运行时间比当前时间早6秒，每秒运行1次，那么程序会先运行6次然后再按照每间隔1秒一次
	@Test
	public void main6() throws ParseException {
		System.out.println("准备");
		Timer timer = new Timer();
		TimerTask timerTask = new timertask();
		Date date = sdf.parse("2017-12-31 19:12:15");
		timer.scheduleAtFixedRate(timerTask, date,1000);
	}
	
	
	
	//特殊情况2表现1
	//当运行的程序时间超过了，任务调度时间间隔，那么schedule会在运行结束后再运行
	//所以运行时间会一直被延后
	//下面例子是1秒后运行，每间隔3秒1次，运行时间需要5秒
	@Test
	public void main7() throws ParseException {
		System.out.println("准备");
		Timer timer = new Timer();
		timertask2 timerTask2 = new timertask2();
		timer.schedule(timerTask2, 1000,1000);
	}
	//特殊情况2表现2
	//当运行的程序时间超过了，任务调度时间间隔，那么scheduleAtFixedRate会按照上次执行的开始时间间隔执行，也就是不会延后，会正常执行，所以会出现并发执行
	//所以运行时间不会被延后
	//下面例子是1秒后运行，每间隔3秒1次，运行时间需要5秒
	@Test
	public void main8() throws ParseException {
		System.out.println("准备");
		Timer timer = new Timer();
		timertask2 timerTask2 = new timertask2();
		timer.scheduleAtFixedRate(timerTask2, 1000,1000);
	}
	//关闭所有任务方法
	@Test
	public void main9() throws ParseException, InterruptedException {
		System.out.println("准备");
		Timer timer = new Timer();
		timertask timerTask1 = new timertask("任务1");
		timertask timerTask2 = new timertask("任务2");
		timer.scheduleAtFixedRate(timerTask1, 1000,1000);
		timer.scheduleAtFixedRate(timerTask2, 1000,1000);
		
		System.out.println("已关闭的任务数"+timer.purge());//从队列中移除被关闭的任务并且返回移除的数量
		
		Thread.sleep(10*1000);
//		timer.cancel();//关闭timer下的所有任务
		timerTask1.cancel();//关闭timerTask1任务
		System.out.println("全部关闭");
		System.out.println("已关闭的任务数"+timer.purge());//从队列中移除被关闭的任务并且返回移除的数量,如果任务被全部关闭那么返回0
	}
	//测试并发执行
	@Test
	public void main10() throws ParseException, InterruptedException {
		Timer timer = new Timer();
		Timer timer2 = new Timer();
		timertask3 timerTask1 = new timertask3("任务1");
		timertask3 timerTask2 = new timertask3("任务2");
		timer.scheduleAtFixedRate(timerTask1, 2000,20000);
		timer2.scheduleAtFixedRate(timerTask2, 4000,20000);
	}
	
	
	
	public static void main(String[] args) throws ParseException, InterruptedException {
		new tt().main10();
	}
}