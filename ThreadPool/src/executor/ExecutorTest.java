package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池，ExecutorService线程池管理者，newFixedThreadPool(2)线程池中限制的线程数量
 * @author xunfeng
 *
 */
public class ExecutorTest {

	private ExecutorService executorService  = Executors.newFixedThreadPool(3);
	public static void main(String[] args) {
		ExecutorTest test = new ExecutorTest();
		System.out.println("main:" + Thread.currentThread().getName()); 
		test.Test("str1");
		test.Test("str2");
		test.Test("str3");
		test.Test("str4");
		test.Test("str5");
		test.Test("str6");
		
	}

	public void Test(String str){
		executorService.submit(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(""+str);
				System.out.println(str+":" + Thread.currentThread().getId()); 
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
