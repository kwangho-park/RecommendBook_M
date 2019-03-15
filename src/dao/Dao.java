package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.UserInfoDto;

public class Dao {
	
	private DataSource dataSource;
	
	// server directory context.xml의 설정된 connection pool 생성
	public Dao() {
		try {

			// ?? //
			Context context = new InitialContext();

			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");

			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	} // Dao() END
	
	
	
	
	// login 시 ID, PW를 조회하는 로직
	public ArrayList<UserInfoDto> SelectLoginUserInfo() {
		
		ArrayList<UserInfoDto> dtoList = new ArrayList<UserInfoDto>();		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = dataSource.getConnection();
			
			String query = "SELECT id, pw FROM userInfo";
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery(); // [예외발생]
			
			
			while(rs.next()){
				String id = rs.getString("id");
				int pw = rs.getInt("pw");
				
				UserInfoDto dto = new UserInfoDto();
				dto.setId(id);
				dto.setPw(pw);
				
				dtoList.add(dto);
			}
			System.out.println("DB pstmt/connection close ");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return dtoList;
		
	} //SelectLoginUserInfo() END
	
	
	
	// signUp 시 id를 조회 // 
	public ArrayList<UserInfoDto> selectSignUpUserInfo() {
		
		ArrayList<UserInfoDto> dtoList = new ArrayList<UserInfoDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		try {
			
			
			// id를 조회하는 로직
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
		
	} // selectSignUpUserInfo() END
	
} // Dao END
