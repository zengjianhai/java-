package bruip.demo1;

public class Xiancheng {
	public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		String name = thread.getName();
		System.out.println(name+"�̵߳�����      ��ʼ");
		Thread thread2 = new MyThread();
		thread2.start();
		Xiancheng xiancheng = new Xiancheng();
		xiancheng.test();
		Thread thread3 = new MyThread1();
		thread3.start();
		try {
			//�ȵ��߳����н����������н���main�߳�
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + "�̵߳�����      ����");
	}
	public void test(){
		Thread thread = Thread.currentThread();
		String name = thread.getName();
		for (int i = 0; i < 10; i++) {
			System.out.println(name+"\t�߳���");
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
			System.out.println(name+"\t�ҵ��߳���");
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
			System.out.println(name+"\t�ҵ��߳���1");
		}
		super.run();
	}
}
