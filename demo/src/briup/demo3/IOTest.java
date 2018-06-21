package briup.demo3;

import java.awt.im.InputContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class IOTest {

	public static void main(String[] args) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		outputStream = System.out;
		inputStream = System.in;
		byte[] b = new byte[10];
		try {
//			int len = inputStream.read(b);
//			System.out.println(Arrays.toString(b));
//			System.out.println(len);
			int l = -1;
			while ((l = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, l);
			}
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
