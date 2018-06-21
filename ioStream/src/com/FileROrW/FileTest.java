package com.FileROrW;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		File file1 = null;
		File file2 = null;
		try {
			file1 = new File("F:/MyJava/ioStream/src/test2");
			file2 = new File("src/test3");
			System.out.println(file1.exists() + " read:" + file1.canRead() + " write:" + file1.canWrite() + " execute:"
					+ file1.canExecute());
			if(!file2.exists()){
				file2.createNewFile();
			}
			File file3 = new File("F:/file");
			File file4 = new File("src/PipeStreamTest");
			File file5 = new File("./PipeStreamTest");
			String[] files = file4.list();
//			for (String string : files) {
//				//第一个参数是父目录,第二个参数是子目录
//				new File(file3,string).createNewFile();
//			}
			System.out.println("file1绝对:"+file1.getAbsolutePath());
			System.out.println("file2绝对:"+file2.getAbsolutePath());
			System.out.println(file1.getParent());
			System.out.println(file2.getParent());
			System.out.println(file1.getPath());
			System.out.println(file2.getPath());
			//去掉了绝对的'./'
			System.out.println("file5:"+file5.getCanonicalPath());
			System.out.println("file5:"+file5.getAbsolutePath());
			System.out.println("file5:"+file5.getParent());
			System.out.println("file5:"+file5.getPath());
			
		} catch (Exception e) {
		}
	}
}
