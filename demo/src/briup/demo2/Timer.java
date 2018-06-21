package briup.demo2;

import java.util.TimerTask;

public class Timer implements Myrun {
	Myrun myrun;
	long l, l1, l2;
	boolean flag;
	Thread thread = new Thread();

	public Timer(Myrun myrun, long l) {
		this.myrun = myrun;
		this.l = l;
//		run();
	}

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		String name = thread.getName();
		while (!flag) {
			try {
				System.out.println(name + "\t线程名");
				thread.sleep(this.l);
				stop(this.l1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void start() {
		thread.start();
	}

	public void stop(long l1) {
		this.l1 = l1;
		this.l2 = this.l2 + this.l;
//		System.out.println(this.l2 + "\t线程名");
//		System.out.println(this.l1 + "\t线程名");

		if (this.l2 == (l1+this.l)) {
			flag = true;
		}
	}
}
