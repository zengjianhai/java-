package calculate;

import randomDesign.GetRandom;

/**
 * ���󻬶�����2048����,���������������
 * 
 * @author xunfeng
 *
 */
public class Line {
	static int[][] a_get = new int[][]{ { 2, 4, 2, 2 }, { 0, 8, 0, 0 }, { 2, 4, 2, 2 }, { 8, 0, 0, 0 } };
	// �����ݴ�������������ݣ��Ѹ���������ĵ������Ȱ�Ĭ�ϵ����󻬶�������������ٰ����ݷ�����a_get���飬�õ����������Ľ��
	int[][] a = new int[4][4];
	int[] b;
	int count = 0;
	// 2048ÿһ����ӵĴ���
	int value = 0;
	int tar = 0;

	/**
	 * ����ÿһ�еķǿ�����
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
	 * ����ÿһ�У���2048������ÿһ�е��߼�
	 * 
	 * @param i
	 */
	void getArr(int i) {
		// ÿһ��ʵ����һ������b
		b = new int[count];
		count = 0;
		// ��ÿһ���еķǿ�Ԫ���ݴ��b����
		for (int j = 0; j < a.length; j++) {
			if (a[i][j] != 0) {
				b[count] = a[i][j];
				a[i][j] = 0;
				count++;
			}
		}
		// ���ǿյ�Ԫ�ز�����,Ԫ��Ψһֱ�Ӵ��a����ÿһ�еĵ�һ��
		if (count == 1) {
			a[i][0] = b[0];
		} else {
			// ��Ԫ����ͬ�Ĵ��������Ӻ���0
			for (int m = 0; m < count - 1; m++) {
				if (b[m] == b[m + 1]) {
					b[m] = b[m] + b[m];
					b[m + 1] = 0;
				}
			}
			// �ǿյ�Ԫ�ش���a���鴦�����һ��
			for (int n = 0; n < count; n++) {
				if (b[n] == 0) {
					value++;
				} else {
					a[i][n - value] = b[n];
					System.out.println("a[" + i + "][" + n + "]=" + a[i][n]);
				}
			}
			// ��b������0�Ĳ��ִ���a����
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
	 * dao����������������
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

	// ���з�װ������ͬ���������ṩ���
	void init(CalculateDao dao, CalculateDao dao2) {
		getDesign(new CalculateDao() {

			@Override
			public void design(int i, int j) {
				// line.a[i][j]
				// =line.a_get[line.a_get.length-1-j][line.a_get.length-1-i];
				// //��
				dao.design(i, j);
				// line.a[i][j] = line.a_get[i][line.a_get.length-1-j]; //�������һ���
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
				// //�Ѵ������һ��������ݻ�ԭ
				// line.a_get[i][j]
				// =line.a[line.a_get.length-1-j][line.a_get.length-1-i];
				System.out.println("a_get[" + i + "][" + j + "]=" + a_get[i][j]);
			}
		});
	}

	public static void main(String[] args) {
		Line line = new Line();
		// GetRandom gRandom = new GetRandom(a_get);      =========
		// ����a����
		// line.getDesign(new CalculateDao() {
		//
		// @Override
		// public void design(int i, int j) {
		// // line.a[i][j]
		// =line.a_get[line.a_get.length-1-j][line.a_get.length-1-i]; //��
		// line.a[i][j] = line.a_get[j][i]; // ��
		// // line.a[i][j] = line.a_get[i][line.a_get.length-1-j]; //�������һ���
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
		// ��ӡ��������a������
		// line.getDesign(new CalculateDao() {
		//
		// @Override
		// public void design(int i, int j) {
		// line.a_get[i][j] = line.a[j][i];
		// // line.a_get[i][j] = line.a[i][line.a_get.length-1-j];
		// // //�Ѵ������һ��������ݻ�ԭ
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
	 * ���ⲿ�ṩ
	 */
//	public Line(int[][] context,CalculateDao dao, CalculateDao dao2) {
//		a_get = context;
//		init(dao, dao2);
//	}
}
