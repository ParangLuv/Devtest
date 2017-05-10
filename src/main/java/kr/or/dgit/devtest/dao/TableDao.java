package kr.or.dgit.devtest.dao;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.devtest.jdbc.Config;
import kr.or.dgit.devtest.jdbc.DBConnector;

public class TableDao {

	private DBConnector dbConnector;

	public TableDao(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

	public void createTable(int dbNo) throws ClassNotFoundException, SQLException{
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
	
	
}
