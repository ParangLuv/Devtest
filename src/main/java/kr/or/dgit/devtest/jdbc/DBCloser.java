package kr.or.dgit.devtest.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// DB 접속종료 구현체
public class DBCloser {

	public static void close(Statement stmt) throws SQLException {
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
	}

	public static void close(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
			rs = null;
		}
	}

}
