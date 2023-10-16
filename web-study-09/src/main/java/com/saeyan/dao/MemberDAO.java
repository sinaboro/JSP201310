package com.saeyan.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.saeyan.dto.MemberVO;

//싱글톤 패턴 -- MemeberDAO 하나만 생성하겠다.

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds;
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public int userCheck(String userid, String pwd) {
		return 0;
	}
	
	public MemberVO getMember(String userid) {
		MemberVO vo =null;
		return vo;
	}
	
	
	//중복체크
	public int confirmID(String userid) {
		return 0;
	}
	
	public int insertMember(MemberVO vo) {
		return 0;
	}
	
	public int updateMember(MemberVO vo) {
		return 0;
	}
	
}
