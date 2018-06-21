package briup.file;

import java.io.File;

public class FileMkdir {

	public static void main(String[] args) {
		// 创建文件夹
		File file = new File("F:" + File.separator + "file" + File.separator + "代码创建");
		if (file.exists()) {
		} else {
			file.mkdir();
		}
	}

}
