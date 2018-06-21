package com.FileROrW;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {
		FileReader fReader = null;
		BufferedReader bReader = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
 		try {
			long start = System.currentTimeMillis();
			fReader = new FileReader("src/test3");
			bReader = new BufferedReader(fReader);
			String str = null;
			while ((str = bReader.readLine())!=null) {
				System.out.println(str);
			}
//			fis = new FileInputStream("src/test3");
//			bis = new BufferedInputStream(fis);
//			int str = 0;
//			byte[] bs = new byte[fis.available()];
//			while ((str = bis.read(bs))!=-1) {
//				System.out.println(str);
//			}
//			System.out.println(new String(bs));
			System.out.println("运行时间："+(System.currentTimeMillis()-start));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
