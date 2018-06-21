package schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Timer�������׳��쳣ʱ��ȱ�ݣ�Timer��ֹͣ�������������
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
		 * ScheduledExecutorService���Ա�֤��task1�����쳣ʱ����Ӱ��task2������
		 */
		//�鿴CPU������java.lang.Runtime.availableProcessors() �������ص�Java������Ŀ��õĴ���������
		int count = Runtime.getRuntime().availableProcessors();
		System.out.println("count:" + count);
		
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		pool.schedule(task1, 100, TimeUnit.MILLISECONDS);
		pool.scheduleAtFixedRate(task2, 0, 1000, TimeUnit.MILLISECONDS);
	}
}
