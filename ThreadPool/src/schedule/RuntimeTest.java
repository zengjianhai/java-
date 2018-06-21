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
		// 查看电脑系统的版本
		String osName = System.getProperty("os.name");
		System.out.println("windows的版本:" + osName);
		try {
			/**
			 * 第一种方法
			 * String[] cmdArray{  "cmd", "/c", "ipconfig" }相当于String command
			 */
//			Runtime rt = Runtime.getRuntime();
//			Process proc = rt.exec("ipconfig");
//			InputStream stderr = proc.getErrorStream();
			/**
			 * 第二种
			 * redirectErrorStream(true)方法将错误输出流转移到标准输出流中
			 * 这样使用一次process.getInputStreamReader()就能读出该进程的所有输出
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
