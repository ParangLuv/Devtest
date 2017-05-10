package kr.or.dgit.devtest.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

// DB 접속 인터페이스
public interface DBConnector {

	public Connection getConnection() throws ClassNotFoundException, SQLException;
	
	public void closeConnection(Connection con) throws ClassNotFoundException, SQLException;
	
}
