package briup.file;

import java.io.File;

public class FileMkdir {

	public static void main(String[] args) {
		// �����ļ���
		File file = new File("F:" + File.separator + "file" + File.separator + "���봴��");
		if (file.exists()) {
		} else {
			file.mkdir();
		}
	}

}
