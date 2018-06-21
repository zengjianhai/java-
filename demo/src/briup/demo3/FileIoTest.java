package briup.demo3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIoTest {

	public static void main(String[] args) {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		String file = "src/briup/demo3/q.txt";
		try {
			inputStream = new FileInputStream(file);
			outputStream = new FileOutputStream("src/briup/demo3/q2.txt");

			byte[] b = new byte[512];
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
