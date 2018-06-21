package schedule;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Timer在进行定时操作时只会创建一个线程，所以如果存在多个任务，且任务时间过长，超过了两个任务的间隔时间，会发生一些缺陷
 * @author xunfeng
 *
 */
public class ThreadScheduleTest {
	private static long start;

	public static void main(String[] args) {
		ScheduledExecutorService sExecutorService = Executors.newScheduledThreadPool(2);
		TimerTask task1 = new TimerTask() {

			@Override
			public void run() {
				try {
					System.out.println("task1:" + (System.currentTimeMillis() - start));
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		TimerTask task2 = new TimerTask() {

			@Override
			public void run() {
				System.out.println("task2:" + (System.currentTimeMillis() - start));
			}
		};
		TimerTask task3 = new TimerTask() {

			@Override
			public void run() {
				System.out.println("timer_task2:" + (System.currentTimeMillis() - start));
			}
		};
		start = System.currentTimeMillis();
		sExecutorService.schedule(task1, 1000, TimeUnit.MILLISECONDS);
		sExecutorService.schedule(task2, 3000, TimeUnit.MILLISECONDS);
		Timer timer = new Timer();
		timer.schedule(task1, 1000);
		timer.schedule(task3, 3000);
	}
}
