package com.briup.view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.briup.bean.UserBean;
import com.briup.server.IUserServer;
import com.briup.server.UserServerImpl;

import briup.jdbcTest.Handler;
import briup.jdbcTest.JDBCTemplate;

/**
 * ע�����
 * 
 * @author Administrator
 *
 */
public class RegisterView extends JFrame {
	private static int count;
	private IUserServer server;
	private boolean flag;
	private boolean fl;
	// North Area
	private Canvas canvas;
	// Center Area
	private JPanel centerPan;
	private GridBagLayout gbl = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private JLabel nameLb = new MyLabel("��  ��  ");
	private JTextField nameTf = new JTextField(16);
	private JLabel pwdLb = new MyLabel("��  ��  ");
	private JPasswordField pwdTf = new JPasswordField(16);
	private JLabel genderLb = new MyLabel("��  ��  ");
	public JRadioButton maleRb = new JRadioButton("��", true);
	public JRadioButton femaleRb = new JRadioButton("Ů", false);
	private JLabel telLb = new MyLabel("��  ��  ");
	private JTextField telTf = new JTextField(16);
	private JLabel addressLb = new MyLabel("��  ַ  ");
	private JTextArea addressTa = new JTextArea(3, 16);
	// South Area

	private JPanel southPan = new MyPanel();
	private JButton resetBtn = new MyButton("����");

	private JButton registerBtn = new MyButton("ע��");

	public RegisterView() {

		initComponent();
		server = new UserServerImpl();
	}

	private void initComponent() {
		buildNorth();
		buildCenter();
		buildSouth();

		add(BorderLayout.NORTH, canvas);
		add(BorderLayout.CENTER, centerPan);
		add(BorderLayout.SOUTH, southPan);

		setTitle("Estore - �û�ע��");
		setResizable(false);
		setVisible(false);
		CommonSetting.initShape(this, 328, 300);
		resetBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setNull();
			}
		});
		registerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameTf.getText().trim();
				String passwd = pwdTf.getText().trim();
				String tel = telTf.getText();
				String address = addressTa.getText();
				if (name.equals("")) {
					JOptionPane.showMessageDialog(null, "�������û���");
				} else if (passwd.equals("")) {
					JOptionPane.showMessageDialog(null, "�������û�����");
				} else {
					new JDBCTemplate().execute("select * from tbl_user", new Handler() {

						@Override
						public void handler(ResultSet rs) {
							try {
								while (rs.next()) {
									count++;
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					});
					UserBean user = new UserBean(++count, name, passwd, tel, address);
					String result = server.register(user);
					System.out.println(user.getName()+user.getPasswd());
					JOptionPane.showMessageDialog(null, result);
					setVisible(false);
					new LoginView().setVisible(true);
				}
			}
		});
	}

	private void buildNorth() {
		canvas = new Canvas() {
			@Override
			public void paint(Graphics g) {
				g.drawImage(Toolkit.getDefaultToolkit().getImage(RegisterView.class.getResource("/images/login.gif")),
						0, 0, 324, 47, null, this);
			}
		};
		canvas.setSize(324, 47);
	}

	private void buildCenter() {
		JPanel centerPan = new InsetPanel(new Insets(5, 5, 5, 5));
		// centerPan.setBorder(BorderFactory.createLineBorder(new
		// Color(0x90,0xB9,0xD7), 1));
		centerPan.setBackground(new Color(0xF1, 0xFA, 0xFF));
		centerPan.setLayout(gbl);
		gbl.setConstraints(nameLb, gbc);
		centerPan.add(nameLb);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbl.setConstraints(nameTf, gbc);
		centerPan.add(nameTf);
		gbc.gridwidth = 1;
		gbl.setConstraints(pwdLb, gbc);
		centerPan.add(pwdLb);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbl.setConstraints(pwdTf, gbc);
		centerPan.add(pwdTf);
		gbc.gridwidth = 1;
		gbl.setConstraints(genderLb, gbc);
		centerPan.add(genderLb);
		maleRb.setFont(new Font("����", Font.PLAIN, 12));
		maleRb.setBackground(new Color(0xF1, 0xFA, 0xFF));
		gbl.setConstraints(maleRb, gbc);
		centerPan.add(maleRb);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		femaleRb.setFont(new Font("����", Font.PLAIN, 12));
		femaleRb.setBackground(new Color(0xF1, 0xFA, 0xFF));
		gbl.setConstraints(femaleRb, gbc);
		centerPan.add(femaleRb);
		gbc.gridwidth = 1;
		gbl.setConstraints(telLb, gbc);
		centerPan.add(telLb);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbl.setConstraints(telTf, gbc);
		centerPan.add(telTf);
		gbc.gridwidth = 1;
		gbl.setConstraints(addressLb, gbc);
		centerPan.add(addressLb);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets.bottom = 0;
		gbl.setConstraints(addressTa, gbc);
		addressTa.setBorder(BorderFactory.createLineBorder(new Color(0x7A, 0x8A, 0x99)));
		addressTa.setLineWrap(true);
		centerPan.add(addressTa);

		ButtonGroup genderBg = new ButtonGroup();
		genderBg.add(maleRb);
		genderBg.add(femaleRb);

		this.centerPan = new InsetPanel(new Insets(5, 5, 5, 5));
		this.centerPan.setLayout(new BorderLayout());
		this.centerPan.add(centerPan);
	}

	private void buildSouth() {
		southPan.add(resetBtn, SwingConstants.CENTER);
		southPan.add(registerBtn, SwingConstants.CENTER);
	}

	// �������Լ�ע�ᰴť�����¼�������
	public void addActionListeners(ActionListener[] ls) {
		// cancelBtn.addActionListener(ls[0]);
		registerBtn.addActionListener(ls[1]);

		/*
		 * registerBtn.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 * String name=nameTf.getText().trim(); if(name.equals("")){
		 * JOptionPane.showMessageDialog(null, "�������û���"); return; }
		 * if(name.contains(" ")){ JOptionPane.showMessageDialog(null,
		 * "�û��������Ƿ��ַ�"); return; } String pwd=pwdTf.getText().trim();
		 * if(pwd.equals("")){ JOptionPane.showMessageDialog(null, "����������");
		 * return; } if(pwd.contains(" ")){ JOptionPane.showMessageDialog(null,
		 * "��������Ƿ��ַ�"); return; } Customer customer=null;
		 * customer.setName(name); customer.setPassword(pwd); String
		 * tel=telTf.getText().trim(); customer.setTelephone(tel); String
		 * address=addressTa.getText().trim(); customer.setAddress(address);
		 * flag=maleRb.isSelected(); if(flag){ customer.setGender("��");
		 * 
		 * } fl=femaleRb.isSelected(); if(fl=false){ customer.setGender("Ů"); }
		 * try { icustomerImpl.region(customer);
		 * JOptionPane.showMessageDialog(null, "ע��ɹ�"); } catch
		 * (CustomerException e1) { e1.printStackTrace();
		 * JOptionPane.showMessageDialog(null, e1.getMessage()); }
		 * 
		 * } }); cancelBtn.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * nameTf.setText("");
		 * 
		 * } });
		 * 
		 */

	}

	/*
	 * public Customer getCus(){ Customer customer=new Customer();
	 * customer.setName(nameTf.getText());
	 * customer.setPassword(pwdTf.getText());
	 * customer.setTelephone(telTf.getText());
	 * customer.setAddress(addressTa.getText());
	 */
	/*
	 * flag=maleRb.isSelected(); if(flag){ customer.setGender("��");
	 * 
	 * } fl=femaleRb.isSelected(); if(fl=true){ customer.setGender("Ů"); }
	 * return customer; }
	 */
	public void setNull() {
		nameTf.setText("");
		pwdTf.setText("");
		telTf.setText("");
		addressTa.setText("");
	}

	public static void main(String[] args) {
		new RegisterView();
	}
}