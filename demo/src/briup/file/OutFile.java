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
			/*�����FileOutputStream(file)����ִ�е�ʱ����ԭ�������ݸ����ǵ�
			 * FileOutputStream(file,true),Ϊtrue�Ǳ�ʾ����׷������s
			 * */
			outputStream = new FileOutputStream("F:\\file" + File.separator + "test.txt",true);
			String string="hello world";
			byte[] bs = string.getBytes();
			try {
				//write(bs,0,5)��ʾ��0����5��д��
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
