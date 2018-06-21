package com.socketTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server {
	JTextArea tArea;
	JTextField text;
	JButton start;
	JButton button;

	public Server(JTextArea tArea, JTextField text) {
		this.tArea = tArea;
		this.text = text;
	}

	ServerSocket ss = null;
	Socket socket = null;
	PrintWriter pw = null;
	BufferedReader br = null;

	public void link(PrintWriter pw, BufferedReader br, ServerSocket ss, Socket socket) {
		try {
			socket = ss.accept();
			pw = new PrintWriter(socket.getOutputStream());
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.pw = pw;
			this.br = br;
			this.socket = socket;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ServerClient(int post) {
		try {
			boolean is = true;
			ss = new ServerSocket(post);
			while (is) {
				link(pw, br, ss, socket);
				boolean flag = true;
				while (flag) {
					String value = null;
					try {
						value = br.readLine();
					} catch (Exception e) {
						flag = false;
						tArea.append("客户端断开\n");
					}
					if (value == null || "".equals(value)) {
						flag = false;
					} else {
						tArea.append("客户端:" + value + "\n");
						System.out.println(text.getText());
						if ("bye".equals(value)) {
							flag = false;
						} else {
							write(pw);
						}
					}
				}
				pw.close();
				socket.close();
			}
			if (ss != null) {
				stop(ss);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stop(ServerSocket ss) {
		try {
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(PrintWriter pw) {
		pw = this.pw;
		pw.println(text.getText());
		if (text.getText().equals("") || text.getText() == null) {
		} else {
			tArea.append("\t服务端:" + text.getText() + "\n");
		}
		pw.flush();
		text.setText("");
		text.requestFocus();
	}
}
