package com.outPutStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test1 {

	public static void main(String[] args) {
		File file = new File(
				"F:" + File.separator + "file" + File.separator + "outPutStreamTest" + File.separator + "test1");
		OutputStream ops = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			ops = new FileOutputStream(file,true);
			String string = "\r\nzeng";
			byte[] bs = new byte[1024];
			bs = string.getBytes();
			ops.write(bs);
			ops.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
