package bruip.demo1;

public class RunnableTest implements Runnable {
	//��̳У���ۺϣ�Ҫ�������ü̳У������ýӿ���ʵ��
	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		String name = thread.getName();
//		for (int i = 0; i < 10; i++) {
		int i = 0;
			while (i!=5) {
				System.out.println(name + "\t�߳���");
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
