package briup.file;

import java.io.File;

public class FileList {

	public static void main(String[] args) {
		// ��ӡ�ļ�Ŀ¼
		File file = new File("F:" + File.separator);
		File[] files = file.listFiles();
		//�ж��ļ��Ƿ��ǿյ�
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i]);
				//�ж��ļ��Ƿ���Ŀ¼
				if (files[i].isDirectory()) {
					File[] isfiles = files[i].listFiles();
					//�ж�Ŀ¼�ļ��Ƿ��ǿյģ��ǿյľ��䲻��
					if (isfiles != null) {
						for (int j = 0; j < isfiles.length; j++) {
							System.out.println("\t"+isfiles[j]);
						}
					}
				} else {
					System.out.println("�ļ�����Ŀ¼");
				}
			}
		}
		String[] string = file.list();
		for (int i = 0; i < string.length; i++) {
			System.out.println(string[i]);
		}
	}

}
