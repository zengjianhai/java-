package briup.jdbcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBCģ���
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

	// ������ֵ���н����
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

	// ������ֵ��û�н����
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

	// û������ֵ���н����
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
		//��ѯ
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
		//���ھͲ����
		String intosql = "insert into tbl_demo1 values(?,?)";
		new JDBCTemplate().execute(intosql, new PreSetter() {

			int count = 0;

			@Override
			public void setter(PreparedStatement pst) {
				//��ѯ�Ƿ����
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
							System.out.println("�����Ѵ���");
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				
				try {
					//�����ھ����
					if (count == 0) {
						pst.setInt(1,4);
						pst.setString(2, "kai");
					} else {
						System.out.println("�����Ѵ���");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		//��ѯ���е�
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
