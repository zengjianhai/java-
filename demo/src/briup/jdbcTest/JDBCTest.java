package briup.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		JDBCTest jdbcTest = new JDBCTest();
		jdbcTest.create();
		jdbcTest.add();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet rSet = null;
	public void create(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jianhai", "xunfeng");
			statement = connection.createStatement();
			rSet = statement.executeQuery("create table tbl_demo2(id number(2) primary key,name varchar2(10))");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void add(){
		try {
			rSet = statement.executeQuery("insert into tbl_demo2 values(1,'hai')");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}	

}
