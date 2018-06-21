package com.socketDemo1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketDemo1 {

	public static void main(String[] args) {
		SocketDemo1 socketDemo1 = new SocketDemo1();
		socketDemo1.SocketClient();
	}

	public void SocketClient() {
		Socket socket = null;
		BufferedReader br = null;
		BufferedReader in = null;
		PrintWriter pw = null;
		try {
			socket = new Socket("127.0.0.1", 8989);
			System.out.println("�ͻ������ӳɹ�");
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			in = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(socket.getOutputStream());
			boolean is = true;
			while (is) {
				System.out.println("����:");
				String str = in.readLine();
				pw.println(str);
				pw.flush();
				
				if ("bye".equals(str)) {
					is = false;
				} else {
					String value = null;
					try {
						value = br.readLine();
						System.out.println(value);
					} catch (Exception e) {
						is = false;
						System.out.println("��������Ͽ�");
					}
				}
			}
			socket.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}