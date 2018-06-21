package schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Timer当任务抛出异常时的缺陷，Timer会停止所有任务的运行
 * 
 * @author xunfeng
 *
 */
public class ScheduleExcepionTest {
	public static void main(String[] args) throws InterruptedException {
		final TimerTask task1 = new TimerTask() {

			@Override
			public void run() {
				throw new ExceptionInInitializerError();
			}
		};

		final TimerTask task2 = new TimerTask() {

			@Override
			public void run() {
				System.out.println("task2 invoked!");
			}
		};

		// Timer timer = new Timer();
		// timer.schedule(task1, 100);
		// timer.scheduleAtFixedRate(task2, new Date(), 1000);
		/**
		 * ScheduledExecutorService可以保证，task1出现异常时，不影响task2的运行
		 */
		//查看CPU个数。java.lang.Runtime.availableProcessors() 方法返回到Java虚拟机的可用的处理器数量
		int count = Runtime.getRuntime().availableProcessors();
		System.out.println("count:" + count);
		
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		pool.schedule(task1, 100, TimeUnit.MILLISECONDS);
		pool.scheduleAtFixedRate(task2, 0, 1000, TimeUnit.MILLISECONDS);
	}
}
