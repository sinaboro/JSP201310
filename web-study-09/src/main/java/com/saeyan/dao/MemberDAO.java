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

	//로그인 check
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
	
	
	//userid 해당하는 데이타 가져오기
	public MemberVO getMember(String userid) {
		MemberVO vo =null;
		String sql = "select * from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("userid");
				String pwd = rs.getString("pwd");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				int admin = rs.getInt("admin");
				
				vo = new MemberVO();
				vo.setName(name);
				vo.setUserid(id);
				vo.setEmail(email);
				vo.setPwd(pwd);
				vo.setPhone(phone);
				vo.setAdmin(admin);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}
	
	
	//중복체크
	public int confirmID(String userid) {
		
		int result = -1;
		
		String sql = "select userid from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 conn = getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, userid);
			 rs = pstmt.executeQuery();
			 if(rs.next()) {
				 result = 1;  //아이디 존재
			 }else {
				 result = -1;
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) rs.close();
				if(conn != null) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	//회원 가입
	public int insertMember(MemberVO vo) {
		int result=-1;
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. db연결
			conn = getConnection();
			//2. sql구문을 오라클 전달
			pstmt = conn.prepareStatement(sql);
			//3. 맵핑.
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
			pstmt.setInt(6, vo.getAdmin());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	//회원 수정
	public int updateMember(MemberVO vo) {
		int result=-1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set name=?, pwd=?, email=?, phone = ?,admin=? where userid = ?";
		try {
			
			//1. db연결
			conn = getConnection();
			//2. sql구문을 오라클 전달
			pstmt = conn.prepareStatement(sql);
			//3. 맵핑.
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPhone());
			pstmt.setInt(5, vo.getAdmin());
			pstmt.setString(6, vo.getUserid());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
}






























