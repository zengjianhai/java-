package file;

import java.util.Arrays;
import java.util.Scanner;

public class Mar {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		FileTest fileTest[] = null;
		fileTest = new FileTest[2];
		// �����¼�ļ����ļ�
		FileTest fileTemp[] = null;
		fileTemp = new FileTest[2];
		// �����¼�ļ��±��ļ�
		int temp = 0;
		fileTest[0] = new FileTest();
		fileTest[0].setFlag(1);
		fileTest[0].setName("file1");
		fileTest[0].setString("�ļ�1");
		fileTest[1] = new FileTest();
		fileTest[1].setFlag(0);
		fileTest[1].setName("file2");
		fileTest[1].setString("�ļ�2");
		User user[] = new User[2];
		user[0] = new User();
		user[0].setName("zeng");
		user[0].setLength(2);
		user[0].setFileTest(fileTest);
		user[1] = new User();
		user[1].setName("hai");
		user[1].setLength(2);
		user[1].setFileTest(fileTest);
		boolean flag = true;
		while (flag) {
			System.out.print("�������û�����");
			String string = in.next();
			for (int i = 0; i < user.length; i++) {
				if (string.equals(user[i].getName())) {
					temp = i;
					flag = false;
				}
			}
		}
		flag = false;
		fileTemp = user[temp].getFileTest();
		System.out.println("�����ļ���");
		for (int i = 0; i < fileTemp.length; i++) {
			if (fileTemp[i] != null) {
				System.out.println("�ļ�����" + fileTemp[i].getName());
			}
		}
		while (true) {
			System.out.println("�ɲ����ļ���");
			for (int i = 0; i < fileTemp.length; i++) {
				if (fileTemp[i] != null && fileTemp[i].isFlag() > 0) {
					System.out.println("�ļ�����" + fileTemp[i].getName());
				}
			}
			System.out.println("1.creat\n2.delet\n3.open\n4.lose\n5.read\n6.write\n0.exit");
			System.out.print("��ѡ���ܣ�");
			int ch = in.nextInt();
			int tap = -1;
			String string;
			switch (ch) {
			case 1:
				for (int i = 0; i < fileTemp.length; i++) {
					if (fileTemp[i] == null) {
						tap = i;
					}
				}
				if (tap == -1) {
					fileTemp = Arrays.copyOf(fileTemp, fileTemp.length + 1);
					tap = fileTemp.length - 1;
					fileTemp[tap] = new FileTest();
				}
				System.out.print("�������ļ�����");
				String name = in.next();
				fileTemp[tap].setName(name);
				fileTemp[tap].getName();
				System.out.print("���������ݣ�");
				String str = in.next();
				fileTemp[tap].setString(str);
				System.out.print("�������Ƿ�ɶ���");
				int flag2 = in.nextInt();
				fileTemp[tap].setFlag(flag2);
				user[temp].setFileTest(fileTemp);
				tap = -1;
				break;
			case 2:
				System.out.print("��������Ҫɾ�����ļ�����");
				string = in.next();
				for (int i = 0; i < fileTemp.length; i++) {
					if (fileTemp[i] != null) {
						if (string.equals(fileTemp[i].getName())) {
							fileTemp[i] = null;
						}
					}
				}
				user[temp].setFileTest(fileTemp);
				break;
			case 3:
				System.out.print("��������Ҫ�򿪵��ļ�����");
				string = in.next();
				for (int i = 0; i < fileTemp.length; i++) {
					if (fileTemp[i] != null) {
						if (string.equals(fileTemp[i].getName())) {
							System.out.println(fileTemp[i].getName());
						}
					}
				}
				break;
			case 4:
				System.out.print("��������Ҫ�رյ��ļ�����");
				System.out.println("�ļ��ѹرգ�");
				break;
			case 5:
				System.out.print("��������Ҫ�������ļ�����");
				string = in.next();
				for (int i = 0; i < fileTemp.length; i++) {
					if (fileTemp[i] != null) {
						if (string.equals(fileTemp[i].getName())) {
							System.out.println("�ļ����ݣ�"+fileTemp[i].getString());
						}
					}
				}
				break;
			case 6:
				System.out.print("��������Ҫд����ļ�����");
				string = in.next();
				for (int i = 0; i < fileTemp.length; i++) {
					if (fileTemp[i] != null) {
						if (string.equals(fileTemp[i].getName())) {
							System.out.print("���������ݣ�");
							string = in.next();
							fileTemp[i].setString(string);
						}
					}
				}
				break;

			default:
				break;
			}
		}
	}
}

