package file;

public class Shufa {

	public static void main(String[] args) {
		char[] cs = { '2', '3', '4' };
		sort(cs, 0, cs.length - 1);
	}

	public static void sort(char[] c, int start, int end) {
		if (start == end) {
			System.out.print("µ›πÈ≈≈–Ú£∫\t");
			for (int i = 0; i <= end; i++) {
				System.out.print(c[i] + "\t");
			}
			System.out.println();
		} else {
			for (int i = start; i <= end; i++) {
				char temp = c[start];
				c[start] = c[i];
				c[i] = temp;
				sort(c, start + 1, end);
				c[i] = c[start];
				c[start] = temp;
			}
		}
	}

}
