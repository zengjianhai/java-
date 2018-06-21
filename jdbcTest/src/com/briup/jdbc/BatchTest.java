package com.briup.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchTest {

	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement ps;
	public static void main(String[] args) {
        connection=ConnectionFactory.getConnection();
        try {
        	String sql="insert into stu values(?,?,?,?)";
        	ps=connection.prepareStatement(sql);
        	for(int i=0;i<50000;i++){
        		ps.setInt(1, i);
        		ps.setString(2, "briup"+i);
        		ps.setString(3, "briup_"+i);
        		ps.setInt(4, 18);
        		ps.addBatch();
        		if(i%5000==0){
        			ps.executeBatch();
        			ps.clearBatch();
        		}
        	}
        	ps.executeBatch();
			/*statement=connection.createStatement();
			String sql="insert into stu values(1,'tom','123',20)";
			
			String sql2="update stu set age=30 where id=1";
			statement.addBatch(sql);
			statement.addBatch(sql2);
			statement.executeBatch();*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
