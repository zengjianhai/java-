package com.briup.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static Properties properties;
	private static Connection connection;
	static{
		properties=new Properties();
		try {
			FileInputStream fis=new FileInputStream("src/jdbc.properties");
			properties.load(fis);
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			username=properties.getProperty("user");
			password=properties.getProperty("pwd");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection
					//使用两参数，此时Properties中的用户名key只能是user，密码必须是password
					//(url,properties);
					(url,username,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public static void main(String[] args) {
		System.out.println(ConnectionFactory.getConnection());
	}
}
