package demo;

public class test {

	public void info() {
		int[] a = new int[] { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1 };
		int[] b = new int[] { -1, -1, -1 };
		int[] c = new int[] { 0, 0, 0 };
		int count = 0;
		Integer integer1 = 128;
		Integer integer2 = 128;
		System.out.println(integer1 == integer2);
		System.out.println("ĞòºÅ" + "\t" + "1" + "\t" + "2" + "\t" + "3" + "\t" + "×´Ì¬");
		System.out.println("-----------------------------------");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (i < 3) {
					b[i] = a[i];
					c[i]++;
					if (b[0] != a[i]) {
						c[0]++;
					} else if (b[1] != a[i]) {
						c[1]++;
					} else {
						c[2]++;
					}
				} else {
					if (b[j] == a[i]) {
						c[j] = 1;
					} else {
						count++;
						c[j]++;
					}
				}
			}
			if (count == 3) {
				if (c[0] > c[1] && c[0] > c[2]) {
					c[0] = 1;
					b[0] = a[i];
				} else if (c[1] > c[0] && c[1] > c[2]) {
					c[1] = 1;
					b[1] = a[i];
				} else {
					c[2] = 1;
					b[2] = a[i];
				}
				System.out.println(a[i] + "\t" + b[0] + "\t" + b[1] + "\t" + b[2] + "\t" + "È±Ò³");
			} else {
				if (i < 3) {
					System.out.println(a[i] + "\t" + b[0] + "\t" + b[1] + "\t" + b[2] + "\t" + "È±Ò³");
				} else {
					System.out.println(a[i] + "\t" + b[0] + "\t" + b[1] + "\t" + b[2] + "\t" + "²»È±Ò³");
				}
			}
			count = 0;
		}
	}
	public void say(){
		System.out.println("hello nimei!");
	}

	public static void main(String[] args) {
		test test = new test();
		test.info();
	}
}
