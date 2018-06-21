package com.intPutStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class test1 {

	public static void main(String[] args) {
		File file = new File("F:"+File.separator+"file"+File.separator
				+"inPutStreamTest"+File.separator+"test1.txt");
		InputStream ips = null;
		try {
			if(file.exists()){
				ips = new FileInputStream(file);
				//得到的文件的长度
				byte[] bs = new byte[(int)file.length()];
				//读到的在输入流中的数据字节长度,一个文字两个字节
				int i = ips.read(bs);
				//将数据读到byte数组中
				ips.read(bs);
				//把byte型转成String类型
				String string = new String(bs,0,i);
				System.out.println(string);
				System.out.println("输入流数据的长度："+i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
