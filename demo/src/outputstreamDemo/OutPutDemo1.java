package outputstreamDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutPutDemo1 {

	public static void main(String[] args) throws Exception{
		
		File file = new File("F:/file"+File.separator+"test2.txt");
		OutputStream outputStream=null;
		outputStream = new FileOutputStream(file);
		String string = "zengjianhai";
		byte[] bs = string.getBytes();
		for(int i = 0;i<bs.length;i++){
			outputStream.write(bs,0,5);
		}
		outputStream.close();
	}
}
