package com.socketTest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ServerInterface {
	static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	static ServerInterface sInterface;
	static boolean is = false;
	static Server server;
	static PrintWriter pWriter;
	public static void main(String[] args) {
		sInterface = new ServerInterface();
		sInterface.View();
		server = new Server(text, textField);
	}
	static JTextField textField;
	static JTextArea text;

	public void View() {
		JFrame jFrame = new JFrame("服务器");
		JPanel left = new JPanel();
		JPanel jPanel = new JPanel();
		text = new JTextArea(20, 20);
		textField = new JTextField(15);
		JButton button = new JButton("发送");
		JButton btn = new JButton("启动");
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(text);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		jPanel.add(scrollPane);
		jPanel.add(textField);
		jPanel.add(button);
		left.add(btn);
		button.addActionListener(new Send());
		btn.addActionListener(new Start());
		jFrame.getContentPane().add(BorderLayout.PAGE_END, left);
		jFrame.getContentPane().add(BorderLayout.CENTER, jPanel);
		ServerInterface.initShape(jFrame, 400, 500);
		jFrame.setVisible(true);
	}

	public class Send implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			server.write(pWriter);
		}
	}

	public static class Start implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!is) {
				is = true;
			} else {
				is = false;
			}
			new Thread(new Runnable() {
				public void run() {
					text.append("等待客户端连接\n");
					while (true) {
						if (is)
							server.ServerClient(8989);
					}
				}
			}).start();
		}
	}

	static void initShape(JFrame c, int width, int height) {
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2 - 40;

		c.setLocation(x, y);
		c.setSize(width, height);
	}
}
