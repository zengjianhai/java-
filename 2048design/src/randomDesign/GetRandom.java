package randomDesign;

import java.util.Random;

import javax.naming.Context;

import calculate.CalculateDao;
import calculate.Line;
import randomDesign.Ran;

/**
 * ����2048��Ϊ�յ���������߼�
 * 
 * @author xunfeng
 *
 */
public class GetRandom {
	static int[][] a = new int[][]{ { 2, 4, 2, 2 }, { 0, 8, 0, 0 }, { 2, 4, 2, 2 }, { 8, 0, 0, 0 } };
//	int[][] a_g = new int[4][4]; //         =========�еȺŵ�һ��
	int value = 0, ranValue = 0;
	Random ran = new Random();
	int[] b;
	int count = 0;

	public static void main(String[] args) {
		GetRandom getRandom = new GetRandom();
		getRandom.getRandom();
//		Line line = new Line(a,new CalculateDao() {       =========
//			
//			@Override
//			public void design(int i, int j) {
//				// TODO Auto-generated method stub
//				getRandom.a_g[i][j] = a[j][i];
//			}
//		},new CalculateDao() {
//			
//			@Override
//			public void design(int i, int j) {
//				// TODO Auto-generated method stub
//				a[i][j] = getRandom.a_g[j][i];
//			}
//		});
	}

	public GetRandom() {
	}
	//���ⲿ�ṩ���
//	public GetRandom(int[][] context) {
//		a = context;
//		getRandom();
//	}

	/**
	 * ��װgetFor()����,���ڶ��ʹ��
	 * 
	 * @param cgGetRandom
	 * @param ran
	 */
	public void getFor(Ran ran) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				ran.getCount(i, j);
			}
		}
	}
	/**
	 * ��������ṩһ�����
	 * @param i
	 * @param j
	 * @param ran
	 */
	void init(int i, int j, Ran ran) {
		if (a[i][j] == 0) {
			ran.getCount(i, j);
			count++;
		}
	}

	void getRandom() {
		// �����Ϊ�յĸ���
		getFor(new Ran() {
			@Override
			public void getCount(int i, int j) {
				// if (a[i][j] == 0) {
				// count++;
				// }
				init(i, j, new Ran() {

					@Override
					public void getCount(int i, int j) {
						// TODO Auto-generated method stub

					}
				});
			}
		});
		// ʵ����һ������Ԫ�ظ���Ϊ�յ�������������Ϊ�յ�λ��
		b = new int[count];
		count = 0;
		getFor(new Ran() {
			@Override
			public void getCount(int i, int j) {
				// if (a[i][j] == 0) {
				// b[count] = 4 * i + j;
				// count++;
				// }
				init(i, j, new Ran() {

					@Override
					public void getCount(int i, int j) {
						// TODO Auto-generated method stub
						b[count] = 4 * i + j;
					}
				});
			}
		});
		// ����ڿ�Ԫ��������
		value = (int) (Math.random() * count);
		getFor(new Ran() {
			@Override
			public void getCount(int i, int j) {
				if (b[value] == 4 * i + j) {
					a[i][j] = b[value];
					System.out.println("i=" + i + "\tj=" + j);
				}
			}
		});

		/**
		 * ��������Ϸ���
		 */
		// for (int i = 0; i < a.length; i++) {
		// for (int j = 0; j < a.length; j++) {
		// if (a[i][j] == 0) {
		// count++;
		// }
		// }
		// }
		// b = new int[count];
		// count = 0;
		// for (int i = 0; i < a.length; i++) {
		// for (int j = 0; j < a.length; j++) {
		// if (a[i][j] == 0) {
		// b[count] = 4 * i + j;
		// count++;
		// }
		// }
		// }
		// value = (int) (Math.random() * count);
		// for (int i = 0; i < a.length; i++) {
		// for (int j = 0; j < a.length; j++) {
		// if (b[value] == 4 * i + j) {
		// System.out.println("i=" + i + "\tj=" + j);
		// }
		// }
		// }
	}
}
