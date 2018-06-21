package com.socketTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SocketClient {
	JTextArea tArea;
	JTextField text;
	JTextField ip;
	JTextField host;
	boolean is = true;

	public SocketClient(JTextArea tArea, JTextField text, JTextField ip, JTextField host) {
		this.tArea = tArea;
		this.text = text;
		this.ip = ip;
		this.host = host;
	}

	Socket socket = null;
	BufferedReader br = null;
	BufferedReader in = null;
	PrintWriter pw = null;

	public void socketCli(String host, int post) {
		try {
			link(br, pw, host, post);
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
					tArea.append("服务器:" + value + "\n");
					System.out.println(text.getText());
					if ("bye".equals(value)) {
						flag = false;
					} else {
						write(pw, text.getText());
					}
				}
			}
			socket.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void write(PrintWriter pw, String str) {
		pw = this.pw;
		pw.println(str);
		pw.flush();
		if (str.equals("") || str == null) {
		}else{
			tArea.append("\t客户端:" + text.getText() + "\n");
		}
		text.setText("");
		text.requestFocus();
	}

	public void link(BufferedReader br, PrintWriter pw, String host, int post) {
		try {
			socket = new Socket(host, post);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			this.br = br;
			this.pw = pw;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
