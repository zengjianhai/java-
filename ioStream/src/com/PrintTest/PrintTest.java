package com.PrintTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class PrintTest {
	public static void main(String[] args){
		File file = new File("src/test3");
		try {
			FileOutputStream outputStream = new FileOutputStream(file);
			//����true�Զ��ύ,ÿ���һ���ύһ�£��쳣ǰ��Ķ����ύ
			PrintWriter pw = new PrintWriter(outputStream,true);
			pw.println(true);
			pw.println(Math.random());
			pw.println(10);
			pw.println("hello world");
			//�ֶ��ύ,û���쳣���ύ
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
