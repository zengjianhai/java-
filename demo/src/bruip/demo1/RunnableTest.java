package bruip.demo1;

public class RunnableTest implements Runnable {
	//轻继承，多聚合，要尽量少用继承，可以用接口来实现
	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		String name = thread.getName();
//		for (int i = 0; i < 10; i++) {
		int i = 0;
			while (i!=5) {
				System.out.println(name + "\t线程名");
				i++;
//			}
		}
	}

	public static void main(String[] args) {
		Runnable runnable = new RunnableTest();
		Thread t = new Thread(runnable);
		t.start();
	}
}
