package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	//로그인
	public int userCheck(String userid, String pwd) {
		int result = -1;
		String sql = "select pwd from member where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			 conn = getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, userid);
			 rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 if(rs.getString("pwd").equals(pwd)) {
					 result = 1;
				 }else {
					 result = 0;
				 }
					 
			 }else {
				 result = -1;
			 }
			 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
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











