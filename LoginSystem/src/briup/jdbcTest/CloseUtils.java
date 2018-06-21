package briup.jdbcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 关闭资源工具类
 * 
 * @author JianHai
 * 
 */
public class CloseUtils {
	public static void closeResource(Connection conn, PreparedStatement preStatement, ResultSet rs) {

		try {
			if (rs != null)
				rs.close();
			if (preStatement != null)
				preStatement.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static void closeResource(Connection conn, PreparedStatement preStatement) {
		closeResource(conn, preStatement, null);
	}
	
	public static void closeResource(Connection conn) {
		closeResource(conn, null, null);

	}
	
}
