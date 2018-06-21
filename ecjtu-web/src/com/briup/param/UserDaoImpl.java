package com.briup.param;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoImpl implements UserDao {
	private static Connection conn;
	static {
		conn = ConnectionFactory.getConnection();
		System.out.println("======");
	}

	@Override
	public void saveUser(User user) {
		PreparedStatement ps;
		try {
			String sql = "insert into u values(my_user.nextval,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getGender());
			ps.setString(3, user.getPasswd());
			ps.setString(4, user.getHobby());
			ps.setInt(5, user.getAge());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User findUserByName(String name) {
		User user = null;
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from u where name='" + name + "'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				user = new User();
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setGender(rs.getString("gender"));
				user.setHobby(rs.getString("hobby"));
				user.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> findUserALlByName(String name) {
		return null;
	}

}
