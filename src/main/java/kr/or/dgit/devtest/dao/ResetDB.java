package kr.or.dgit.devtest.dao;

import java.sql.PreparedStatement;

public class ResetDB {

	private PreparedStatement pstmt;

	private static ResetDB instance = new ResetDB();

	public ResetDB() {
		System.out.println("ResetDB Constructor loaded");
	}
	
	
	
	
	
}
