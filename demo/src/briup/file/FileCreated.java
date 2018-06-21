package briup.file;

import java.io.File;
import java.io.IOException;

public class FileCreated {
	public static void main(String[] args) {
		// 声明一个File类
		File file;
		// 实例化，在堆中分配一个new对象给file
		/* file后面的分隔符用/,File.separator表示斜杠 */
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
