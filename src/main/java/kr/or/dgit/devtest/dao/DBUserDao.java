package kr.or.dgit.devtest.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.dgit.devtest.jdbc.Config;
import kr.or.dgit.devtest.jdbc.DBCloser;

public class DBUserDao {

	private PreparedStatement pstmt;

	public void createUser(int dbNo) throws ClassNotFoundException, SQLException{
		try {
			String createUser = "grant select, insert, update, delete on " + Config.DB_NAME + dbNo + ".* to user_ncs@'localhost' identified by 'user_ncs';";
			pstmt.execute(createUser);
			System.out.println("CreateUser Success");
		} catch (Exception e) {
			System.out.println("Error 발생");
			e.printStackTrace();
		} finally {
			DBCloser.close(pstmt);
			System.out.println("DB connection closed");
		}
	}
	
	
}
