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
import kr.or.dgit.devtest.jdbc.JdbcUtil;

public class DataBaseDao {

	private PreparedStatement pstmt;
	private String query = "";
	private static DataBaseDao instance = new DataBaseDao();

	private DataBaseDao() {
		System.out.println("DataBaseDao Constructor loaded");
	}

	public static DataBaseDao getInstance() {
		return instance;
	}

	public void createDataBase(int dbNo) {
		try {
			Connection con = DBCon.getConnection();
			pstmt = con.prepareStatement("Drop Database if exists " + Config.DB_NAME + dbNo);
			pstmt.execute();
			System.out.printf("Drop Database(%s) Success! %n", Config.DB_NAME + dbNo);
			pstmt = con.prepareStatement("Create Database " + Config.DB_NAME + dbNo);
			pstmt.execute();
			System.out.printf("Create Database(%s) Success! %n", Config.DB_NAME + dbNo);
		} catch (SQLException e) {
			System.out.printf("Create Database(%s) Failed! %n", Config.DB_NAME + dbNo);
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			System.out.println("DB connection closed");
		}
	}

	public void createTable(int dbNo) {
		try {
			File initSQL = new File(System.getProperty("user.dir") + "\\script\\ddl.txt");
			List<String> stringList = Files.readAllLines(initSQL.toPath(), StandardCharsets.UTF_8);

			for (String string : stringList) {
				query += string.replaceAll(".$?--.*", "").replaceAll("(?m)^.*--.*$(\r?\n|\r)?", "")
						.replaceAll("\\s+", " ").replaceAll("MY_SCHEMA", Config.DB_NAME + dbNo);
			}

			String[] querys = query.split(";");

			for (String executeQuery : querys) {
				if (executeQuery.trim().startsWith("insert") || executeQuery.trim().startsWith("update")
						|| executeQuery.trim().startsWith("delete")) {
					System.out.println(executeQuery);
					pstmt.executeUpdate(executeQuery);
				} else {
					System.out.println(executeQuery);
					pstmt.execute(executeQuery);
				}
			}
		} catch (Exception e) {
			System.out.println("Error 발생");
			e.printStackTrace();
		} 
	}

	public void createUser(int dbNo) {
		try {
			String createUser = "grant select, insert, update, delete on " + Config.DB_NAME + dbNo + ".* to user_ncs@'localhost' identified by 'user_ncs';";
			pstmt.execute(createUser);
			System.out.println("CreateUser Success");
		} catch (Exception e) {
			System.out.println("Error 발생");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			System.out.println("DB connection closed");
		}
	}

	public void selectUseDatabase(int dbNo) {
		try {
			Connection con = DBCon.getConnection();
			pstmt = con.prepareStatement("USE " + Config.DB_NAME + dbNo);
			pstmt.execute();
			System.out.printf("USE DATABASE(%s) Selected Success! %n", Config.DB_NAME + dbNo);
		} catch (SQLException e) {
			System.out.printf("USE DATABASE(%s) Selected Fail! %n", Config.DB_NAME + dbNo);
			e.printStackTrace();
		} 
	}

}
