package briup.jdbcTest;

import java.sql.PreparedStatement;

public interface PreSetter {
	void setter(PreparedStatement pst);
}
