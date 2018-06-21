package com.socketTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class SocketView {
	static boolean is = false;
	static SocketClient client;
	static PrintWriter pWriter;
	static SocketView view;

	public static void main(String[] args) {
		view = new SocketView();
		view.View();
		client = new SocketClient(text, textField, text_ip, text_host);
	}

	static JTextField textField;
	static JTextArea text;
	static JTextField text_ip;
	static JTextField text_host;

	public void View() {
		JFrame jFrame = new JFrame("客户端");
		JPanel jPanel = new JPanel();
		JPanel start = new JPanel();
		text = new JTextArea(19, 20);
		textField = new JTextField(15);
		JButton button = new JButton("发送");
		JButton btn = new JButton("启动");
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(text);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JLabel ip = new JLabel("IP:");
		JLabel host = new JLabel("端口:");
		text_ip = new JTextField(10);
		text_host = new JTextField(10);
		jPanel.add(ip);
		jPanel.add(text_ip);
		jPanel.add(host);
		jPanel.add(text_host);

		jPanel.add(scrollPane);
		jPanel.add(textField);
		jPanel.add(button);
		start.add(btn);
		btn.addActionListener(new SocketStart());
		button.addActionListener(new SocketSend());
		jFrame.getContentPane().add(BorderLayout.PAGE_END, start);
		jFrame.getContentPane().add(BorderLayout.CENTER, jPanel);
		ServerInterface.initShape(jFrame, 400, 500);
		jFrame.setVisible(true);
	}

	public class SocketSend implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			client.write(pWriter, textField.getText());
		}
	}

	public static class SocketStart implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!is) {
				is = true;
			} else {
				is = false;
			}
			new Thread(new Runnable() {
				public void run() {
					text.append("等待连接服务器\n");
					while (true) {
						if (is)
							client.socketCli(text_ip.getText(), Integer.parseInt(text_host.getText()));
					}
				}
			}).start();
		}
		
	}
}
