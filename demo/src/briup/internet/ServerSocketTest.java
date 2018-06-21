package briup.internet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import briup.internet.BIDR;

import oracle.net.aso.r;

public class ServerSocketTest {

	public static void main(String[] args) {

		ServerSocket server = null;
		Socket socket = null;
		ObjectOutputStream oos = null;
		try {
			// 端口号
			int port = 8989;
			server = new ServerSocket(port);

			// 线程阻塞在这个方法上
			// 服务器等待客户端的连接
			System.out.println("等待客戶端");
			socket = server.accept();
			System.out.println("接受到了");
			System.out.println(socket);

			oos = new ObjectOutputStream(socket.getOutputStream());
			FileReader reader=new FileReader("F:/MyJava/ecjtu/src/radwtmp_test");
            BufferedReader bf=new BufferedReader(reader);
            String line = null;
			String[] strings = null;
			BIDR bIDR = null;
			Map<String, BIDR> map = new HashMap<String, BIDR>();
			List<BIDR> list = new ArrayList<BIDR>();
			while ((line = bf.readLine()) != null) {
				strings = line.split("[|]");
				if ("7".equals(strings[2])) {
					bIDR = new BIDR();
					bIDR.setLogin_name(strings[0]);
					bIDR.setNAS_ip(strings[1]);
					bIDR.setLogin_data(new Timestamp(Long.parseLong(strings[3]) * 1000));
					bIDR.setLogin_ip(strings[4]);
					map.put(strings[4], bIDR);
				} else {
					bIDR = map.get(strings[4]);
					bIDR.setLogout_data(new Timestamp(Long.parseLong(strings[3]) * 1000));
					bIDR.setTime_duretion((int) (map.get(strings[4]).getLogout_data().getTime()
							- map.get(strings[4]).getLogin_data().getTime()) / 1000);
					list.add(bIDR);
				}
			}
			oos.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null)
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (server != null)
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
