package outputstreamDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

public class InputDemo {
	public static void main(String[] args) throws Exception{
		File file = new File("F:/file"+File.separator+"test2.txt");
		InputStream inputStream = null;
		inputStream = new FileInputStream(file);
		byte[] bs = new byte[1024];
		inputStream.read(bs);
		inputStream.close();
		System.out.println("Êä³ö£º"+new String(bs));
	}
}
