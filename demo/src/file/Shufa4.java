package file;

public class Shufa4 {

	void package0(int n, float c, float v[], float w[], float x[]) {
		int i;
		for (i = 0; i < n; i++) {
			x[i] = 0;// 初始状态，所有物品都没有被放入背包
		}

		for (i = 0; i < n; i++) {
			if (w[i] > c) {
				break;
			}

			x[i] = 1;
			c = c - w[i];
			System.out.println("放入第" + (i + 1) + "件物品，背包剩余容量" + c);
		}

		if (i <= n)// 还可以放入一个物品的一部分
		{
			if (i == 3) {
				x[i-1] = c / w[i-1];
			} else {
				x[i] = c / w[i];
				System.out.println("把第" + (i + 1) + "件放入一部分到剩余的" + (w[i] * x[i]) + "部分.背包剩余容量为0");
			}
		}
	}

	void package0_1(int n, float c, float v[], float w[], float x[]) {
		int i;
		for (i = 0; i < n; i++) {
			x[i] = 0;// 初始状态，所有物品都没有被放入背包
		}

		for (i = 0; i < n; i++) {
			if (w[i] > c) {
				break;
			}

			x[i] = 1;
			c = c - w[i];
			System.out.println("放入第" + (i + 1) + "件物品，背包剩余容量" + c);
		}
	}

	public static void main(String[] args) {
		Shufa4 shufa4 = new Shufa4();
		int n = 3;
		float c = 40;
		float v[] = { 24, 15, 25 };
		float w[] = { 15, 10, 10 };// 已经按照单位价值降序排列
		float[] x;
		x = new float[3];
		System.out.println("背包容量：" + c);
		System.out.print("物品所需容量：");
		for (int i = 0; i < x.length; i++) {
			System.out.print(w[i] + "  ");
		}
		System.out.println();
		System.out.println("******背包（可以放入部分）*******");
		shufa4.package0(n, c, v, w, x);
		System.out.println("*******0-1背包（必须放入整个的）******");
		shufa4.package0_1(n, c, v, w, x);
	}

}
