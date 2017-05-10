package kr.or.dgit.devtest.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lombok.Data;

@Data
public class SuperDao {
	protected static String query = "";
	protected static DBConnector dbConnector;
	protected static Connection con;
	protected static PreparedStatement pstmt;
	protected static SuperDao instance = new SuperDao(getDbConnector());
	
	public SuperDao(DBConnector dbConnector){
		this.dbConnector = dbConnector;
	}

	private static DBConnector getDbConnector() {
		return dbConnector;
	}
	
}
