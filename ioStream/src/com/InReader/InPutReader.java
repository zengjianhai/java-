package com.InReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InPutReader {

	public static void main(String[] args){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			fis = new FileInputStream("src/test");
			fos = new FileOutputStream("src/test2",true);
			isr = new InputStreamReader(fis,"utf-8");
			osw = new OutputStreamWriter(fos, "utf-8");
			br = new BufferedReader(isr);
			bw = new BufferedWriter(osw);
			String date = null;
			while ((date = br.readLine())!=null) {
				System.out.println(date);
			}
			bw.write("\r\n√Ùe");
			
			bw.flush();
		} catch (Exception e) {
		}
	}
}
