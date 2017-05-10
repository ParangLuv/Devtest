package kr.or.dgit.devtest;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.or.dgit.devtest.dao.DataBaseDao;
import kr.or.dgit.devtest.jdbc.DaoFactory;

public class Main {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DataBaseDao dao = new DataBaseDao(new DaoFactory().dbConnector());
		dao.createDataBase(0);
		
	}
	
}
