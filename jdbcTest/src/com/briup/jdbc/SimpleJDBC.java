package com.briup.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class SimpleJDBC {

	private static Connection connection;
	private static Statement statement;
	
	public static void main(String[] args) {
		connection=ConnectionFactory.getConnection();
		String sql="insert into stu values(stu_id.nextval,'tom','123',20)";
		String sql2="update stu set age=30";
		String sql3="select * from stu";
		String sql4="delete from stu";
		try {
			connection.setAutoCommit(false);
			getInsert(sql);
			Savepoint s1=connection.setSavepoint("a");
			getUpdate(sql2);
			Savepoint s2=connection.setSavepoint("b");
			getDelete(sql4);
			connection.rollback(s1);
			connection.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*getInsert(sql);
		getSelect(sql3);
		getUpdate(sql2);
		getSelect(sql3);
		getDelete(sql4);
		getSelect(sql3);*/
		
	}
	public static void getInsert(String sql){
		try {
			statement=connection.createStatement();
			int count=statement.executeUpdate(sql);
			System.out.println("插入的条数:"+count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void getSelect(String sql){
		try {
			statement=connection.createStatement();
			boolean flag=statement.execute(sql);
			if(flag){
				ResultSet rs=statement.executeQuery(sql);
				while(rs.next()){
					System.out.println("id:"+rs.getInt("id")+"name:"+rs.getString("name")
					+"pwd"+rs.getString("pwd")+"age"+rs.getInt("age"));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getUpdate(String sql){
		try {
			statement=connection.createStatement();
			int count=statement.executeUpdate(sql);
			System.out.println("更新条数"+count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void getDelete(String sql){
		try {
			statement=connection.createStatement();
			int count=statement.executeUpdate(sql);
			System.out.println("删除条数:"+count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
