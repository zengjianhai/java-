package schedule;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * @author xunfeng
 *
 */
public class RuntimeTest {

	public static void main(String[] args) {
		// �鿴����ϵͳ�İ汾
		String osName = System.getProperty("os.name");
		System.out.println("windows�İ汾:" + osName);
		try {
			/**
			 * ��һ�ַ���
			 * String[] cmdArray{  "cmd", "/c", "ipconfig" }�൱��String command
			 */
//			Runtime rt = Runtime.getRuntime();
//			Process proc = rt.exec("ipconfig");
//			InputStream stderr = proc.getErrorStream();
			/**
			 * �ڶ���
			 * redirectErrorStream(true)���������������ת�Ƶ���׼�������
			 * ����ʹ��һ��process.getInputStreamReader()���ܶ����ý��̵��������
			 */
			Process proc = new ProcessBuilder("ipconfig").redirectErrorStream(true).start();
			InputStream	stderr = proc.getInputStream();
			
			
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			System.out.println("<error></error>");
			while ((line = br.readLine()) != null)
				System.out.println(line);
			System.out.println("");
			int exitVal = proc.waitFor();
			System.out.println("Process exitValue: " + exitVal);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
