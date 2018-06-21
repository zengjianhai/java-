package briup.jdbcTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import oracle.net.aso.p;

public class ConnectionFactory {
	private static String DRIVER;
	private static String URL;
	private static String USER;
	private static String PASSWD;
	
	//��̬�����
	static {
		/*DRIVER = "oracle.jdbc.OracleDriver";
		URL = "jdbc:oracle:thin:@localhost:1521:XE";
		USER = "jianhai";
		PASSWD = "xunfeng";*/
		
		//�ߴ��Ϸ�װ����׼
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream("src/db.properties"));
			DRIVER = pro.getProperty("driver");
			URL = pro.getProperty("url");
			USER = pro.getProperty("user");
			PASSWD = pro.getProperty("passwd");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL,USER,PASSWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}