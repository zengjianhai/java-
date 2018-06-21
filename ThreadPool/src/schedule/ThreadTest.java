package schedule;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {
	private static String string = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest test = new ThreadTest();
		test.getStr("123");
		System.out.println("ThreadTest:"+string);
	}
	public String getStr(String str){
		/**
		 * ��һ��new Thread�̲߳��᷵������,ֻ�����߳���ִ��
		 */
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				string = "str:"+str;
//			}
//		}).start();
		/**
		 * �̳߳�ʵ��
		 */
		ExecutorService service = Executors.newFixedThreadPool(10);
		/**
		 * �ڶ���submit(Callable)�����᷵��һ��Future����,call()���Է���һ��ֵ
		 * Callableʵ����Runnableʵ������
		 */
		Future<String> future = service.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				string = "str:"+str;
				return string;
			}
		});
		try {
			System.out.println("future.get():"+future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return string;
	}
}
