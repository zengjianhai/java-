package com.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class Test1 {

	public static void main(String[] args) {
		File file = new File("F:" + File.separator + "file" + File.separator + 
				"outPutStreamTest" + File.separator + "test1");
		Reader reader = null;
		try {
			reader = new FileReader(file);
			char[] cs = new char[(int)file.length()];
			reader.read(cs);
			reader.close();
			System.out.println(cs);
		} catch (Exception e) {
		}
	}

}
