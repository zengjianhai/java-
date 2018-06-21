package com.outPutStream;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutTest {

	public static void main(String[] args) {
//		byte[] bs={1,2,3,4,5};
//		ByteArrayInputStream in  = new ByteArrayInputStream(bs);
//		BufferedInputStream bis = new BufferedInputStream(in,2);
//		try {
//			System.out.println(bis.read());
//			System.out.println("mark");
//			bis.mark(2);
//			System.out.println("first:"+bis.read());
//			System.out.println("first:"+bis.read());
//			System.out.println("reset:");
//			bis.reset();
//			System.out.println("secord:"+bis.read());
//			System.out.println("secord:"+bis.read());
//			System.out.println("secord:"+bis.read());
//			System.out.println("reset:");
//			bis.reset();
//			System.out.println("third:"+bis.read());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		int num = -9>>2;
		System.out.println(num);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(10);  //第一
		baos.write(-11);    //第二
		baos.write(-1);    //第三
		byte[] bs = baos.toByteArray();
		ByteArrayInputStream bais = new ByteArrayInputStream(bs);
		//跳过n个,表示跳过第一、第二个
		bais.skip(2);
		int date = 0;
		while ((date = bais.read())!=-1) {
			System.out.println(date);
			
		}
	}

}
