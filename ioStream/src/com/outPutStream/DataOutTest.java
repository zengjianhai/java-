package com.outPutStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DataOutTest {

	public static void main(String[] args) {
//		FileOutputStream fos = null;
		FileInputStream fis =null;
		try {
//			fos = new FileOutputStream("F:/file/inPutStreamTest/test1.txt");
//			print(fos);
			fis = new FileInputStream("F:/file/inPutStreamTest/test1.txt");
			get(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void get(InputStream in) throws Exception{
		DataInputStream dis = new DataInputStream(in);
		System.out.println(dis.readDouble());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readInt());
		System.out.println(dis.readLong());
	}
	public static void print(OutputStream out) throws Exception{
		DataOutputStream dos = new DataOutputStream(out);
		dos.writeChars("hello");
		dos.writeBoolean(true);
		dos.writeInt(0);
		dos.writeLong(120);
	}
}
