package com.briup.view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.briup.server.IUserServer;
import com.briup.server.UserServerImpl;

/**
 * ��¼����
 * 
 * @author Administrator
 *
 */
public class LoginView extends JFrame {
	private IUserServer server;//ҵ���߼���
	
	
	private static final long serialVersionUID = -6201525576920747599L;
	// North Area
	private Canvas canvas;
	// Center Area
	private JPanel centerPan;
	private JLabel nameLb = new MyLabel(" ��  �� ");
	private JTextField nameTf = new JTextField(16);
	private JLabel nameTipLb = new JLabel("      ");
	private JLabel pwdLb = new MyLabel(" ��  �� ");
	private JPasswordField pwdTf = new JPasswordField(16);
	private JLabel pwdTipLb = new JLabel("      ");
	// South Area
	private JPanel southPan = new MyPanel();
	private JButton loginBtn = new MyButton("��¼");
	private JButton cancelBtn = new MyButton("����");
	private JButton registerBtn = new MyButton("ע��");

	public LoginView() {
		initComponent();
		server = new UserServerImpl();//����server�����
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡ�û����û���������
				String name = nameTf.getText().trim();
				String passwd = pwdTf.getText().trim();
				
				if(name.equals("")){
					JOptionPane.showConfirmDialog(null, "�������û���");
				}else if(passwd.equals("")){
					JOptionPane.showConfirmDialog(null, "����������");
				}else{
					String result = server.login(name, passwd);
					JOptionPane.showConfirmDialog(null, result);

				}
			}
		});
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nameTf.setText("");
				pwdTf.setText("");

			}
		});
		registerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new RegisterView().setVisible(true);

			}
		});
	}

	private void initComponent() {
		buildNorth();
		buildCenter();
		buildSouth();

		add(BorderLayout.NORTH, canvas);
		add(BorderLayout.CENTER, centerPan);
		add(BorderLayout.SOUTH, southPan);

		setTitle("Estore - �û���¼");
		setResizable(false);
		CommonSetting.initShape(this, 328, 188);
		setVisible(true);
	}

	private void buildNorth() {
		canvas = new Canvas() {
			@Override
			public void paint(Graphics g) {
				g.drawImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/images/login.gif")), 0,
						0, 324, 47, null, this);
			}
		};
		canvas.setSize(324, 47);
	}

	private void buildCenter() {
		JPanel centerPan = new InsetPanel(new Insets(5, 5, 5, 5));
		centerPan.setBorder(BorderFactory.createLineBorder(new Color(0x90, 0xB9, 0xD7), 1));
		centerPan.setBackground(new Color(0xF1, 0xFA, 0xFF));
		centerPan.add(nameLb);
		centerPan.add(nameTf);
		centerPan.add(nameTipLb);
		centerPan.add(pwdLb);
		centerPan.add(pwdTf);
		centerPan.add(pwdTipLb);

		this.centerPan = new InsetPanel(new Insets(5, 5, 5, 5));
		this.centerPan.setLayout(new BorderLayout());
		this.centerPan.add(centerPan);
	}

	private void buildSouth() {
		southPan.add(registerBtn, SwingConstants.CENTER);
		southPan.add(cancelBtn, SwingConstants.CENTER);
		southPan.add(loginBtn, SwingConstants.CENTER);
	}

	public void setNull() {
		nameTf.setText("");
		pwdTf.setText("");
	}

	public static void main(String[] args) {
		new LoginView();
	}
}
