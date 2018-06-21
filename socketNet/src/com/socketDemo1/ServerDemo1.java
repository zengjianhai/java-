package com.socketDemo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket通信用PrintWriter和BufferedRead
 * 
 * @author xunfeng
 *
 */
public class ServerDemo1 {

	public static void main(String[] args) {
		ServerDemo1 serverDemo1 = new ServerDemo1();
		serverDemo1.ServerClient();
	}

	public void ServerClient() {
		ServerSocket ss = null;
		Socket socket = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		BufferedReader in = null;
		try {
			ss = new ServerSocket(8989);
			boolean is = true;
			while (is) {
				socket = ss.accept();
				System.out.println("服务器连接成功");
				pw = new PrintWriter(socket.getOutputStream());
				in = new BufferedReader(new InputStreamReader(System.in));
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				boolean flag = true;
				while (flag) {
					String value = null;
					try {
						value = br.readLine();
					} catch (Exception e) {
						flag = false;
						System.out.println("客户端断开");
					}
					if (value == null || "".equals(value)) {
						flag = false;
					} else {
						System.out.println("客户端:" + value);
						if ("bye".equals(value)) {
							flag = false;
						} else {
							System.out.println("输入:");
							String str = in.readLine();
							pw.println("服务器:" + str);
							pw.flush();
						}
					}
				}
//				pw.close();
				socket.close();
			}
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
