package briup.jdbcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC模板块
 * 
 * @author JianHai
 * 
 */
public class JDBCTemplate {
	private Connection conn;

	public JDBCTemplate() {
		this(null);
	}

	public JDBCTemplate(Connection conn) {
		if (conn == null) {
			this.conn = ConnectionFactory.getConnection();
		} else {
			this.conn = conn;
		}
	}

	// 有输入值，有结果集
	public void execute(String sql, PreSetter ps, Handler handler) {
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		try {
			pStatement = conn.prepareStatement(sql);
			if (ps != null) {
				ps.setter(pStatement);
			}
			rSet = pStatement.executeQuery();
			if (handler != null) {
				handler.handler(rSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtils.closeResource(conn, pStatement, rSet);
		}
	}

	// 有输入值，没有结果集
	public void execute(String sql, PreSetter ps) {
		PreparedStatement pStatement = null;
		try {
			pStatement = conn.prepareStatement(sql);
			if (ps != null) {
				ps.setter(pStatement);
			}
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtils.closeResource(conn, pStatement);
		}
	}

	// 没有输入值，有结果集
	public void execute(String sql, Handler handler) {
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		try {
			pStatement = conn.prepareStatement(sql);
			rSet = pStatement.executeQuery(sql);
			if (handler != null) {
				handler.handler(rSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtils.closeResource(conn, pStatement, rSet);
		}
	}

	public static void main(String[] args) {
		//查询
		String sql = "select * from tbl_demo1 where id=?";
		new JDBCTemplate().execute(sql, new PreSetter() {

			@Override
			public void setter(PreparedStatement pst) {
				try {
					pst.setInt(1, 2);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}, new Handler() {

			@Override
			public void handler(ResultSet rs) {
				try {
					while (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						System.out.println(id + "\tthis is\t" + name);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		//存在就不添加
		String intosql = "insert into tbl_demo1 values(?,?)";
		new JDBCTemplate().execute(intosql, new PreSetter() {

			int count = 0;

			@Override
			public void setter(PreparedStatement pst) {
				//查询是否存在
				new JDBCTemplate().execute("select * from tbl_demo1", new Handler() {

					@Override
					public void handler(ResultSet rs) {
						try {
							while (rs.next()) {
								int id = rs.getInt("id");
								if (id == 10) {
									count++;
								}
							}
							System.out.println("数据已存在");
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				
				try {
					//不存在就添加
					if (count == 0) {
						pst.setInt(1,4);
						pst.setString(2, "kai");
					} else {
						System.out.println("数据已存在");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		//查询所有的
		String selsql = "select * from tbl_user";
		new JDBCTemplate().execute(selsql, new Handler() {

			@Override
			public void handler(ResultSet rs) {
				try {
					while (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						System.out.println(id + "\t" + name);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

	}
}
