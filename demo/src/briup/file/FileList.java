package briup.file;

import java.io.File;

public class FileList {

	public static void main(String[] args) {
		// 打印文件目录
		File file = new File("F:" + File.separator);
		File[] files = file.listFiles();
		//判断文件是否是空的
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i]);
				//判断文件是否是目录
				if (files[i].isDirectory()) {
					File[] isfiles = files[i].listFiles();
					//判断目录文件是否是空的，是空的就输不出
					if (isfiles != null) {
						for (int j = 0; j < isfiles.length; j++) {
							System.out.println("\t"+isfiles[j]);
						}
					}
				} else {
					System.out.println("文件不是目录");
				}
			}
		}
		String[] string = file.list();
		for (int i = 0; i < string.length; i++) {
			System.out.println(string[i]);
		}
	}

}
