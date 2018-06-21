package com.briup.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.bean.Student;

public class StatementTest {
 private static Connection connection;
 private static Statement statement;
 public static void main(String[] args) {
	connection=ConnectionFactory.getConnection();
	Student student=new Student();
	student.setName("tom");
	student.setPwd("456");
			String sql="select * from stu where name='"+student.getName()+
					"'and pwd="+student.getPwd();
			
			try {
				statement=connection.createStatement();
				ResultSet rs=statement.executeQuery(sql);
				while(rs.next()){
					System.out.println(rs.getInt("id")+rs.getString("name")+rs.getString("pwd"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
}
