package com.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Test1 {

	public static void main(String[] args) {
			File file = new File("F:" + File.separator + "file" + File.separator + 
					"outPutStreamTest" + File.separator + "test1");
			Writer writer = null;
			try {
				writer = new FileWriter(file,true);
				String str = "\r\n������";
				writer.write(str);
				//ǿ������ջ���������,���ر��ַ���Ҳ���Խ��������
				writer.flush();
				if(writer!=null){
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
