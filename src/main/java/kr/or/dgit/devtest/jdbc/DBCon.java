package kr.or.dgit.devtest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// DB 접속 구현체
public class DBCon implements DBConnector{

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(Config.DRIVER);
		Connection con = DriverManager.getConnection(Config.URL, Config.USER, Config.PWD);
		System.out.println("데이터베이스에 접속에 성공하였습니다.");
		return con;
	}

	public void closeConnection(Connection con) throws ClassNotFoundException, SQLException {
		if (con != null) {
			con.close();
			con = null;
			System.out.println("데이터베이스 접속을 성공적으로 종료하였습니다.");
		}
	}

}
