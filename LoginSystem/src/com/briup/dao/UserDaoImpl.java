package com.briup.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.briup.bean.UserBean;

import briup.jdbcTest.Handler;
import briup.jdbcTest.JDBCTemplate;
import briup.jdbcTest.PreSetter;

public class UserDaoImpl implements IUserDao{
	private JDBCTemplate template;
	private UserBean user;

	@Override
	public UserBean findUserByName(final String name) {
		user=null;
		String sql = "select * from tbl_user where name=?";
		template = new JDBCTemplate();
		template.execute(sql, new PreSetter() {
			
			@Override
			public void setter(PreparedStatement pst) {
				try {
					pst.setString(1, name);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}, new Handler() {
			
			@Override
			public void handler(ResultSet rs) {
//				List<UserBean> list = new ArrayList<>();
				try {
					while (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String passwd = rs.getString("passwd");
						String tel = rs.getString("tel");
						String address = rs.getString("address");
						user = new UserBean(id,name,passwd,tel,address);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		return user;
	}

	@Override
	public void saveUser(UserBean user) {
		String sql = "insert into tbl_user values(?,?,?,?,?)";
		template = new JDBCTemplate();
		template.execute(sql, new PreSetter() {
			
			@Override
			public void setter(PreparedStatement pst) {
				try {
					pst.setInt(1, user.getId());
					pst.setString(2, user.getName());
					pst.setString(3, user.getPasswd());
					pst.setString(4, user.getTel());
					pst.setString(5, user.getAddress());
					System.out.println(user.getName()+user.getPasswd());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
