package file;

public class Shufa4 {

	void package0(int n, float c, float v[], float w[], float x[]) {
		int i;
		for (i = 0; i < n; i++) {
			x[i] = 0;// ��ʼ״̬��������Ʒ��û�б����뱳��
		}

		for (i = 0; i < n; i++) {
			if (w[i] > c) {
				break;
			}

			x[i] = 1;
			c = c - w[i];
			System.out.println("�����" + (i + 1) + "����Ʒ������ʣ������" + c);
		}

		if (i <= n)// �����Է���һ����Ʒ��һ����
		{
			if (i == 3) {
				x[i-1] = c / w[i-1];
			} else {
				x[i] = c / w[i];
				System.out.println("�ѵ�" + (i + 1) + "������һ���ֵ�ʣ���" + (w[i] * x[i]) + "����.����ʣ������Ϊ0");
			}
		}
	}

	void package0_1(int n, float c, float v[], float w[], float x[]) {
		int i;
		for (i = 0; i < n; i++) {
			x[i] = 0;// ��ʼ״̬��������Ʒ��û�б����뱳��
		}

		for (i = 0; i < n; i++) {
			if (w[i] > c) {
				break;
			}

			x[i] = 1;
			c = c - w[i];
			System.out.println("�����" + (i + 1) + "����Ʒ������ʣ������" + c);
		}
	}

	public static void main(String[] args) {
		Shufa4 shufa4 = new Shufa4();
		int n = 3;
		float c = 40;
		float v[] = { 24, 15, 25 };
		float w[] = { 15, 10, 10 };// �Ѿ����յ�λ��ֵ��������
		float[] x;
		x = new float[3];
		System.out.println("����������" + c);
		System.out.print("��Ʒ����������");
		for (int i = 0; i < x.length; i++) {
			System.out.print(w[i] + "  ");
		}
		System.out.println();
		System.out.println("******���������Է��벿�֣�*******");
		shufa4.package0(n, c, v, w, x);
		System.out.println("*******0-1������������������ģ�******");
		shufa4.package0_1(n, c, v, w, x);
	}

}
