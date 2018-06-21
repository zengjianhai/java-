package com.briup.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import com.briup.gather.Gather;
import com.briup.bean.BIDR;
import com.briup.xml.ConfigurationImpl;
import com.briup.xml.WossModuleInit;


public class DBImple implements WossModuleInit {
	private PreparedStatement ps;
	private String sql;
	private int k;
	private String driver;
	private String url;
	private String username;
	private String password;
	private Connection connection;
	private int batchSize;
	private static ConfigurationImpl con;
	static {
		con = new ConfigurationImpl();
	}

	@Override
	public void init(Properties properties) {
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		batchSize = Integer.parseInt(properties.getProperty("batch"));
	}

	public static void main(String[] args) {
		try {
			DBImple dbStore = con.getDbStore();
			dbStore.demo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void demo() {
		try {
			int count = 0;
			List<BIDR> list = (List<BIDR>) new Gather().gather();
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			connection.setAutoCommit(false);
			/**
			 * 太慢了
			 */
			// int k1 = 0;
			// for (int i = 0; i < list.size(); i++) {
			// BIDR bidr = list.get(i);
			// // 获取日期
			// k = new Date(bidr.getLogin_date().getTime()).getDate();
			// if (k != k1) {
			// if (ps != null) {
			// ps.executeBatch();
			// connection.commit();
			// ps.close();
			// }
			// sql = "insert into T_DETAIL_" + k + " values(?,?,?,?,?,?)";
			// ps = connection.prepareStatement(sql);
			// }
			// // 根据登陆日期存入相应的表里
			// ps.setString(1, bidr.getLogin_name());
			// ps.setString(2, bidr.getLogin_ip());
			// ps.setString(3, bidr.getNAS_IP());
			// ps.setDate(4, new Date(bidr.getLogin_date().getTime()));
			// ps.setDate(5, new Date(bidr.getLogout_date().getTime()));
			// ps.setInt(6, bidr.getTime_duration());
			// // ps.executeUpdate();
			// ps.addBatch();
			// count++;
			// if (count % batchSize == 0) {
			// ps.executeBatch();
			// connection.commit();
			//
			// }
			// }
			// if (ps != null) {
			// ps.executeBatch();
			// connection.commit();
			// }
			SimpleDateFormat df = new SimpleDateFormat("dd");
			int j = 0;
			for (BIDR bidr : list) {
				System.out.println(bidr.getLogin_date() + "          " + df.format(bidr.getLogin_date()));
				if (count != Integer.valueOf(df.format(bidr.getLogin_date()))) {
					if (ps != null) {
						ps.executeBatch();
						connection.commit();
						ps.close();
					}
					sql = "insert into t_detail_" + df.format(bidr.getLogin_date()) + " values(?,?,?,?,?,?)";
					ps = connection.prepareStatement(sql);
					System.out.println("-------------------------");
				}
				count = Integer.valueOf(df.format(bidr.getLogin_date()));
				// createStatement和prepareStatement是在一个循环里面的话,游标一直在不停的打开，而且没有关闭
				ps.setString(1, bidr.getLogin_name());
				ps.setString(2, bidr.getLogin_ip());
				ps.setString(3, bidr.getNAS_IP());
				ps.setDate(4, new Date(bidr.getLogin_date().getTime()));
				ps.setDate(5, new Date(bidr.getLogout_date().getTime()));
				ps.setInt(6, bidr.getTime_duration());
				ps.addBatch();
				// 游标超出了设置的范围
				if (j % 5000 == 0) {
					ps.executeBatch();
					System.out.println("==================");
					ps.clearBatch();
				}
				j++;
			}
			if (ps != null) {
				ps.executeBatch();
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
