package briup.file;

import java.io.File;
import java.io.IOException;

public class FileCreated {
	public static void main(String[] args) {
		// ����һ��File��
		File file;
		// ʵ�������ڶ��з���һ��new�����file
		/* file����ķָ�����/,File.separator��ʾб�� */
		file = new File("F:\\file" + File.separator + "test.txt");
		if (file.exists()) {
			file.delete();
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
