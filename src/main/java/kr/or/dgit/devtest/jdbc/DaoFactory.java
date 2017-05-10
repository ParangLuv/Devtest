package kr.or.dgit.devtest.jdbc;

import java.sql.SQLException;

import kr.or.dgit.devtest.dao.DataBaseDao;
import kr.or.dgit.devtest.dao.TableDao;

// Dao팩토리
public class DaoFactory {

	// 커넥션 생성
	public DBConnector dbConnector() throws ClassNotFoundException, SQLException{
		return new DBCon();
	}
	
	// 커넥션
	public SuperDao dbDao() throws ClassNotFoundException, SQLException{
		return new SuperDao(dbConnector());
	}

	
}
