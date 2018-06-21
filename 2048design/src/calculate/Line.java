package calculate;

import randomDesign.GetRandom;

/**
 * 按左滑动处理2048数组,计算出处理后的数据
 * 
 * @author xunfeng
 *
 */
public class Line {
	static int[][] a_get = new int[][]{ { 2, 4, 2, 2 }, { 0, 8, 0, 0 }, { 2, 4, 2, 2 }, { 8, 0, 0, 0 } };
	// 用来暂存各滑动方向数据，把各滑动方向的的数据先按默认的向左滑动处理，处理完毕再把数据返还给a_get数组，得到滑动方向后的结果
	int[][] a = new int[4][4];
	int[] b;
	int count = 0;
	// 2048每一行相加的次数
	int value = 0;
	int tar = 0;

	/**
	 * 计算每一行的非空数量
	 * 
	 * @param i
	 * @param j
	 */
	void getNoZeno(int i, int j) {
		if (a[i][j] != 0) {
			count++;
		} else {
		}
	}

	/**
	 * 处理每一行，即2048滑动后每一行的逻辑
	 * 
	 * @param i
	 */
	void getArr(int i) {
		// 每一行实例化一个数组b
		b = new int[count];
		count = 0;
		// 把每一行中的非空元素暂存给b数组
		for (int j = 0; j < a.length; j++) {
			if (a[i][j] != 0) {
				b[count] = a[i][j];
				a[i][j] = 0;
				count++;
			}
		}
		// 都是空的元素不操作,元素唯一直接存给a数组每一行的第一个
		if (count == 1) {
			a[i][0] = b[0];
		} else {
			// 把元素相同的处理掉，相加和至0
			for (int m = 0; m < count - 1; m++) {
				if (b[m] == b[m + 1]) {
					b[m] = b[m] + b[m];
					b[m + 1] = 0;
				}
			}
			// 非空的元素传回a数组处理的这一行
			for (int n = 0; n < count; n++) {
				if (b[n] == 0) {
					value++;
				} else {
					a[i][n - value] = b[n];
					System.out.println("a[" + i + "][" + n + "]=" + a[i][n]);
				}
			}
			// 把b数组至0的部分传给a数组
			if (value == 1) {
				a[i][count - value] = 0;
			} else if (value == 2) {
				a[i][count - value + 1] = 0;
				a[i][count - value] = 0;
			}
			value = 0;
		}
	}

	/**
	 * dao层计算出处理后的数组
	 * 
	 * @param dao
	 */
	public void getDesign(CalculateDao dao) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				dao.design(i, j);
			}
		}
	}

	// 进行封装，给不同滑动方向提供入口
	void init(CalculateDao dao, CalculateDao dao2) {
		getDesign(new CalculateDao() {

			@Override
			public void design(int i, int j) {
				// line.a[i][j]
				// =line.a_get[line.a_get.length-1-j][line.a_get.length-1-i];
				// //下
				dao.design(i, j);
				// line.a[i][j] = line.a_get[i][line.a_get.length-1-j]; //处理向右滑动
				System.out.println("a[" + i + "][" + j + "]=" + a[i][j]);
				getNoZeno(i, j);
				tar++;
				if (tar == 4) {
					getArr(i);
					tar = 0;
					count = 0;
				}
			}
		});
		getDesign(new CalculateDao() {

			@Override
			public void design(int i, int j) {
				dao2.design(i, j);
				// line.a_get[i][j] = line.a[i][line.a_get.length-1-j];
				// //把处理向右滑动的数据还原
				// line.a_get[i][j]
				// =line.a[line.a_get.length-1-j][line.a_get.length-1-i];
				System.out.println("a_get[" + i + "][" + j + "]=" + a_get[i][j]);
			}
		});
	}

	public static void main(String[] args) {
		Line line = new Line();
		// GetRandom gRandom = new GetRandom(a_get);      =========
		// 处理a数组
		// line.getDesign(new CalculateDao() {
		//
		// @Override
		// public void design(int i, int j) {
		// // line.a[i][j]
		// =line.a_get[line.a_get.length-1-j][line.a_get.length-1-i]; //下
		// line.a[i][j] = line.a_get[j][i]; // 上
		// // line.a[i][j] = line.a_get[i][line.a_get.length-1-j]; //处理向右滑动
		// System.out.println("a[" + i + "][" + j + "]=" + line.a[i][j]);
		// line.getNoZeno(i, j);
		// line.tar++;
		// if (line.tar == 4) {
		// line.getArr(i);
		// line.tar = 0;
		// line.count = 0;
		// }
		// }
		// });
		// 打印出处理后的a数组结果
		// line.getDesign(new CalculateDao() {
		//
		// @Override
		// public void design(int i, int j) {
		// line.a_get[i][j] = line.a[j][i];
		// // line.a_get[i][j] = line.a[i][line.a_get.length-1-j];
		// // //把处理向右滑动的数据还原
		// // line.a_get[i][j]
		// =line.a[line.a_get.length-1-j][line.a_get.length-1-i];
		// System.out.println("a_get[" + i + "][" + j + "]=" +
		// line.a_get[i][j]);
		// }
		// });
		line.init(new CalculateDao() {

			@Override
			public void design(int i, int j) {
				// TODO Auto-generated method stub
				line.a[i][j] = line.a_get[j][i];
			}
		}, new CalculateDao() {

			@Override
			public void design(int i, int j) {
				// TODO Auto-generated method stub
				line.a_get[i][j] = line.a[j][i];
			}
		});
	}

	public Line() {

	}
	/**
	 * 给外部提供
	 */
//	public Line(int[][] context,CalculateDao dao, CalculateDao dao2) {
//		a_get = context;
//		init(dao, dao2);
//	}
}
