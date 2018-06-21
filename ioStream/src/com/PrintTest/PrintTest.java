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
			//加入true自动提交,每添加一项提交一下，异常前面的都会提交
			PrintWriter pw = new PrintWriter(outputStream,true);
			pw.println(true);
			pw.println(Math.random());
			pw.println(10);
			pw.println("hello world");
			//手动提交,没有异常才提交
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
