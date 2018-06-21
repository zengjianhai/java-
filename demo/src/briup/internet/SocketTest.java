package briup.internet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;
import java.util.List;

import briup.internet.BIDR;

public class SocketTest {

	public static void main(String[] args) {
		Socket socket = null;
		// ip
		String host = "192.168.43.197";
		// 要和服务器的管口号一样
		int port = 8989;
		try {
			// 只要这个socket对象能创建出来
			// 就表示链接到了服务器
			socket = new Socket(host, port);
			System.out.println("连接成功");
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			List<BIDR> list = (List<BIDR>) ois.readObject();
			for (BIDR bidr : list) {
				System.out.println(bidr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (socket != null)
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
