package com.briup.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.briup.bean.Student;

public class PreStaTest {

	private static Connection connection;
	private static PreparedStatement ps;
	public static void main(String[] args) {
		connection=ConnectionFactory.getConnection();
		Student student=new Student();
		student.setName("tom");
		student.setPwd("123");
	    String sql="select * from stu where name=? and pwd=?";
			try {
				ps=connection.prepareStatement(sql);
				ps.setString(1, student.getName());
				ps.setString(2,student.getPwd());
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					System.out.println(rs.getInt("id")+rs.getString("name")+rs.getString("pwd")
					+rs.getInt("age"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
