package briup.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutFile {

	public static void main(String[] args) {
		OutputStream outputStream=null;
		try {
			/*如果是FileOutputStream(file)，在执行的时候会把原来的内容给覆盖掉
			 * FileOutputStream(file,true),为true是表示可以追加内容s
			 * */
			outputStream = new FileOutputStream("F:\\file" + File.separator + "test.txt",true);
			String string="hello world";
			byte[] bs = string.getBytes();
			try {
				//write(bs,0,5)表示从0到第5个写出
				outputStream.write(bs);
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
