package file;

import java.util.Arrays;
import java.util.Scanner;

public class Mar {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		FileTest fileTest[] = null;
		fileTest = new FileTest[2];
		// 定义记录文件夹文件
		FileTest fileTemp[] = null;
		fileTemp = new FileTest[2];
		// 定义记录文件下标文件
		int temp = 0;
		fileTest[0] = new FileTest();
		fileTest[0].setFlag(1);
		fileTest[0].setName("file1");
		fileTest[0].setString("文件1");
		fileTest[1] = new FileTest();
		fileTest[1].setFlag(0);
		fileTest[1].setName("file2");
		fileTest[1].setString("文件2");
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
			System.out.print("请输入用户名：");
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
		System.out.println("所有文件：");
		for (int i = 0; i < fileTemp.length; i++) {
			if (fileTemp[i] != null) {
				System.out.println("文件名：" + fileTemp[i].getName());
			}
		}
		while (true) {
			System.out.println("可操作文件：");
			for (int i = 0; i < fileTemp.length; i++) {
				if (fileTemp[i] != null && fileTemp[i].isFlag() > 0) {
					System.out.println("文件名：" + fileTemp[i].getName());
				}
			}
			System.out.println("1.creat\n2.delet\n3.open\n4.lose\n5.read\n6.write\n0.exit");
			System.out.print("请选择功能：");
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
				System.out.print("请输入文件名：");
				String name = in.next();
				fileTemp[tap].setName(name);
				fileTemp[tap].getName();
				System.out.print("请输入内容：");
				String str = in.next();
				fileTemp[tap].setString(str);
				System.out.print("请输入是否可读：");
				int flag2 = in.nextInt();
				fileTemp[tap].setFlag(flag2);
				user[temp].setFileTest(fileTemp);
				tap = -1;
				break;
			case 2:
				System.out.print("请输入需要删除的文件名：");
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
				System.out.print("请输入需要打开的文件名：");
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
				System.out.print("请输入需要关闭的文件名：");
				System.out.println("文件已关闭！");
				break;
			case 5:
				System.out.print("请输入需要读出的文件名：");
				string = in.next();
				for (int i = 0; i < fileTemp.length; i++) {
					if (fileTemp[i] != null) {
						if (string.equals(fileTemp[i].getName())) {
							System.out.println("文件内容："+fileTemp[i].getString());
						}
					}
				}
				break;
			case 6:
				System.out.print("请输入需要写入的文件名：");
				string = in.next();
				for (int i = 0; i < fileTemp.length; i++) {
					if (fileTemp[i] != null) {
						if (string.equals(fileTemp[i].getName())) {
							System.out.print("请输入内容：");
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

