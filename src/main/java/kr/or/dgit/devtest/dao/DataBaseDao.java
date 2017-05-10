package kr.or.dgit.devtest.dao;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.devtest.jdbc.Config;
import kr.or.dgit.devtest.jdbc.DBCon;
import kr.or.dgit.devtest.jdbc.DBConnector;
import kr.or.dgit.devtest.jdbc.SuperDao;
import kr.or.dgit.devtest.jdbc.DBCloser;

public class DataBaseDao extends SuperDao{


	public DataBaseDao(DBConnector dbConnector) {
		super(dbConnector);
	}

	
	public void createDataBase(int dbNo) throws ClassNotFoundException, SQLException{
		// DB연결
		con = dbConnector.getConnection();
		
		// 데이터베이스 드랍
		query = "Drop Database if exists " + Config.DB_NAME + dbNo;
		pstmt = con.prepareStatement(query);
		pstmt.execute();
		System.out.printf("Drop Database(%s) Success! %n", Config.DB_NAME + dbNo);
		
		// 데이터베이스 생성
		pstmt = con.prepareStatement("Create Database " + Config.DB_NAME + dbNo);
		pstmt.execute();
		System.out.printf("Create Database(%s) Success! %n", Config.DB_NAME + dbNo);
		
		// DB연결 종료
		DBCloser.close(pstmt);
		System.out.println("DB connection closed");
	}


//
//
//	public void selectUseDatabase(int dbNo) throws ClassNotFoundException, SQLException{
//		try {
//			Connection con = DBCon.getConnection();
//			pstmt = con.prepareStatement("USE " + Config.DB_NAME + dbNo);
//			pstmt.execute();
//			System.out.printf("USE DATABASE(%s) Selected Success! %n", Config.DB_NAME + dbNo);
//		} catch (SQLException e) {
//			System.out.printf("USE DATABASE(%s) Selected Fail! %n", Config.DB_NAME + dbNo);
//			e.printStackTrace();
//		} 
//	}

}
