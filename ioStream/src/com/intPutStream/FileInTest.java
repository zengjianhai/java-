package com.intPutStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(
					"F:" + File.separator + "file" + File.separator + "inPutStreamTest" + File.separator + "test1.txt");
			fos = new FileOutputStream(
					"F:" + File.separator + "file" + File.separator + "outPutStreamTest" + File.separator + "test1");
			byte[] bs = new byte[fis.available()];
			int date = 0;
			while ((date = fis.read(bs))!=-1) {
				fos.write(bs,1,5);
			}
//			System.out.println(fis.read(bs,0,4));
			System.out.println(new String(bs));
//			System.out.println(fis.read(bs,0,5));
//			System.out.println(new String(bs));
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(fis!=null)fis.close();
					if(fos!=null)fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
	}

}
