package com.magic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.magic.dto.EmployeesVO;


public class EmployeesDAO {
private static EmployeesDAO instance = new EmployeesDAO();
	
	private EmployeesDAO() {}
	
	public static EmployeesDAO getInstance() {
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
		public int userCheck(String id, String pass) {
			int result = -1;
			String sql = "select pass from employees where id = ?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				 conn = getConnection();
				 pstmt = conn.prepareStatement(sql);
				 pstmt.setString(1, id);
				 rs = pstmt.executeQuery();
				 
				 if(rs.next()) {
					 if(rs.getString("pass").equals(pass)) {
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
		public EmployeesVO getMember(String id) {
			EmployeesVO vo =null;
			String sql = "select * from employees where id=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
			
				if(rs.next()) {
					vo = new EmployeesVO();
					vo.setName(rs.getString("name"));
					vo.setGender(rs.getString("gender"));
					vo.setLev(rs.getString("lev"));
					vo.setPass(rs.getString("pass"));
					vo.setPhone(rs.getString("phone"));
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
}
