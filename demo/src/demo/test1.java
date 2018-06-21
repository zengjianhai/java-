package demo;

import java.util.Scanner;

public class test1 {
	int jincheng;
	int time;
	int youxian;
	int zuse;
	int wait;
	int zhuangtai;
	User user = new User(time, youxian, zuse, wait);
	User[] users = getUsers();
	int a_get = 0;

	public void create() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入时间：");
		time = scanner.nextInt();
		user.setTime(time);
		System.out.println("请输入优先级：");
		youxian = scanner.nextInt();
		user.setYouxian(youxian);
		System.out.println("请输入阻塞时间：");
		zuse = scanner.nextInt();
		user.setZuse(zuse);
		System.out.println("请输入等待时间：");
		wait = scanner.nextInt();
		user.setWait(wait);
	}

	public void sort() {
		int[] max = new int[users.length];
		int[] get = new int[users.length];
		for (int i = 0; i < users.length; i++) {
			get[i] = users[i].getYouxian();
		}
		for (int i = 0; i < users.length; i++) {
			for (int j = i + 1; j < users.length; j++) {
				if (j == users.length) {
				} else {
					if (get[i] > get[j]) {
					} else {
						max[i] = get[j];
						get[j] = get[i];
						get[i] = max[i];
					}
				}
			}
		}
		for (int i = 0; i < users.length; i++) {
			for (int j = 0; j < users.length; j++) {
				if (get[i] == users[j].getYouxian()) {
					if (i == 0) {
						a_get = j;
					}
					System.out.println("进程" + (j + 1) + "\t时间：" + users[j].getTime() + "\t" + "优先级："
							+ users[j].getYouxian() + "\t");
				}
			}
		}
	}

	public void run() {
		int b = 0, c = 0;
		;
		boolean boo = true;
		while (boo) {
			for (int i = 0; i < users.length; i++) {
				if (users[i].getTime() == 0) {
					c++;
				} else {
				}
				if (c == users.length) {
					boo = false;
				}
			}
			for (int j = 0; j < users.length; j++) {
				if (a_get == j) {
					System.out.println("进程" + (a_get + 1) + "正在运行...");
					users[j].setYouxian(users[j].getYouxian() - 3);
					users[j].setTime(users[j].getTime() - 1);
					if (users[j].getTime() == 0) {
						users[j].setYouxian(-1);
						users[j].setTime(0);
					}
					b++;
					if (b == users[j].getZuse()) {

					}
				} else {
					if (users[j].getTime() == 0) {
					} else {
						users[j].setYouxian(users[j].getYouxian() + 1);
					}
				}
			}
			a_get = 0;
			sort();
		}
	}

	public User[] getUsers() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入进程数：");
		int jincheng = scanner.nextInt();
		User[] creates = new User[jincheng];
		for (int i = 0; i < jincheng; i++) {
			create();
			creates[i] = new User(user.getTime(), user.getYouxian(), user.getZuse(), user.getWait());
		}
		System.out.println("开始：");
		for (int i = 0; i < creates.length; i++) {
			System.out
					.println("进程" + (i + 1) + "\t时间：" + creates[i].getTime() + "\t" + "优先级：" + creates[i].getYouxian());
		}
		System.out.println("按优先级排序：");
		return creates;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		test1 test1 = new test1();
		test1.sort();
		test1.run();
	}

	class User {

		public User(int time, int youxian, int zuse, int wait) {
			this.time = time;
			this.youxian = youxian;
			this.zuse = zuse;
			this.wait = wait;
		}

		int time;
		int youxian;
		int zuse;

		public int getZuse() {
			return zuse;
		}

		public void setZuse(int zuse) {
			this.zuse = zuse;
		}

		public int getWait() {
			return wait;
		}

		public void setWait(int wait) {
			this.wait = wait;
		}

		int wait;

		public int getTime() {
			return this.time;
		}

		public int getYouxian() {
			return this.youxian;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public void setYouxian(int youxian) {
			this.youxian = youxian;
		}
	}
}
