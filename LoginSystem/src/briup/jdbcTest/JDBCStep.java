package briup.jdbcTest;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.OracleDriver;

/**
 * @author ZengJianhai 
 * 2016-12-27
 * JDBC的六大步骤
 * */

public class JDBCStep {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rSet = null;
		try {
			// (1)注册驱动
			  //类加载（常用）
//			Class.forName("oracle.jdbc.OracleDriver");
			  //第二种注册方式，利用Driver加载
			Driver driver = new OracleDriver();
			DriverManager.deregisterDriver(driver);
			  //利用系统
//			-Djdbc.drivers = oracle.jdbc.OracleDriver;
			// (2)获取连接
			  //利用DriverManager(常用)
//			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jianhai", "xunfeng");
			  //直接用Driver
			Properties properties = new Properties();
			properties.put("user", "jianhai");
			properties.put("password", "xunfeng");
			connection = driver.connect("jdbc:oracle:thin:@localhost:1521:XE", properties);
			System.out.println(connection);
			// (3)获取执行sql语句的对象
			  //第一种：statement
//			statement = connection.createStatement();
			  //第二种:PreparedStatement
			PreparedStatement preStatement=connection.prepareStatement("select * from "+"tbl_demo1 where id=?");
			
			// (4)执行sql语句
//			rSet = statement.executeQuery("select * from "+"tbl_demo1");
			preStatement.setInt(1, 2);
			rSet = preStatement.executeQuery();
			  //执行任何语句，返回boolean，有结果集返回true，没有返回false
//			boolean ex = preStatement.execute();
//			System.out.println(ex);
			// (5)处理结果集
			while (rSet.next()) {
				int id = rSet.getInt("id");
				String name = rSet.getString("name");
				System.out.println(id+"\t"+name);
			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// (6)关闭资源
				if(rSet!=null)rSet.close();
				if(statement!=null)statement.close();
				if(connection!=null)connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
