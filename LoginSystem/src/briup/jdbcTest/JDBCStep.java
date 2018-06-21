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
 * JDBC��������
 * */

public class JDBCStep {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rSet = null;
		try {
			// (1)ע������
			  //����أ����ã�
//			Class.forName("oracle.jdbc.OracleDriver");
			  //�ڶ���ע�᷽ʽ������Driver����
			Driver driver = new OracleDriver();
			DriverManager.deregisterDriver(driver);
			  //����ϵͳ
//			-Djdbc.drivers = oracle.jdbc.OracleDriver;
			// (2)��ȡ����
			  //����DriverManager(����)
//			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jianhai", "xunfeng");
			  //ֱ����Driver
			Properties properties = new Properties();
			properties.put("user", "jianhai");
			properties.put("password", "xunfeng");
			connection = driver.connect("jdbc:oracle:thin:@localhost:1521:XE", properties);
			System.out.println(connection);
			// (3)��ȡִ��sql���Ķ���
			  //��һ�֣�statement
//			statement = connection.createStatement();
			  //�ڶ���:PreparedStatement
			PreparedStatement preStatement=connection.prepareStatement("select * from "+"tbl_demo1 where id=?");
			
			// (4)ִ��sql���
//			rSet = statement.executeQuery("select * from "+"tbl_demo1");
			preStatement.setInt(1, 2);
			rSet = preStatement.executeQuery();
			  //ִ���κ���䣬����boolean���н��������true��û�з���false
//			boolean ex = preStatement.execute();
//			System.out.println(ex);
			// (5)��������
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
				// (6)�ر���Դ
				if(rSet!=null)rSet.close();
				if(statement!=null)statement.close();
				if(connection!=null)connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
