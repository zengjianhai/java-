package bruip.demo1;

public class Xiancheng {
	public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		String name = thread.getName();
		System.out.println(name+"线程的名字      开始");
		Thread thread2 = new MyThread();
		thread2.start();
		Xiancheng xiancheng = new Xiancheng();
		xiancheng.test();
		Thread thread3 = new MyThread1();
		thread3.start();
		try {
			//等到线程运行结束，再运行结束main线程
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + "线程的名字      结束");
	}
	public void test(){
		Thread thread = Thread.currentThread();
		String name = thread.getName();
		for (int i = 0; i < 10; i++) {
			System.out.println(name+"\t线程名");
//			if(i==5){
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		}
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		String name = thread.getName(); 
		for (int i = 0; i < 10; i++) {
			System.out.println(name+"\t我的线程名");
		}
		super.run();
	}
}
class MyThread1 extends Thread {
	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		String name = thread.getName(); 
		for (int i = 0; i < 10; i++) {
			System.out.println(name+"\t我的线程名1");
		}
		super.run();
	}
}
