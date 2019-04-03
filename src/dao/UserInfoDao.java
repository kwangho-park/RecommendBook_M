package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.UserInfoDto;

public class UserInfoDao {
	
	private DataSource dataSource;
	
	// server directory context.xml의 설정된 connection pool 생성
	public UserInfoDao() {
		try {

			// ?? //
			Context context = new InitialContext();

			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");

			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	} // UserInfoDao() END
	
	
	
	
	// login 시 ID, PW를 조회 // 
	public ArrayList<UserInfoDto> select() {
		
		ArrayList<UserInfoDto> dtoList = new ArrayList<UserInfoDto>();		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = dataSource.getConnection();
			
			String query = "SELECT id, pw FROM userInfo";
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()){
				String id = rs.getString("id");
				int pw = rs.getInt("pw");
				
				UserInfoDto dto = new UserInfoDto();
				dto.setId(id);
				dto.setPw(pw);
				
				dtoList.add(dto);
			}

			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				System.out.println("DB pstmt/connection close ");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return dtoList;
		
	} //select() END
	
	
	
	// signUp 시 id 중복 조회 // 
	public boolean filter(String signUpId) {
		
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		try {
			
			// id를 조회하는 로직
			conn = dataSource.getConnection();
			
			String query = "SELECT id FROM userInfo WHERE id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,signUpId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("id");
				
				if(id.equals(signUpId)) {
					result = true;
				}
			}
			
	
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				System.out.println("DB pstmt/connection close ");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	} // filter() END
	
	
	
	public void insert(UserInfoDto userInfoDto) {
		

		Connection conn = null;
		PreparedStatement pstmt = null;

		
		try {
			conn = dataSource.getConnection();
			
			String query = "INSERT INTO userInfo VALUES(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userInfoDto.getId());
			pstmt.setInt(2, userInfoDto.getPw());
			pstmt.setString(3, userInfoDto.getUserName());
			pstmt.setString(4, userInfoDto.getBirthday());
			pstmt.setString(5, userInfoDto.getEmail());
			pstmt.setString(6, userInfoDto.getAddress());
			pstmt.setString(7, userInfoDto.getSignUpProcess());
			pstmt.setString(8, userInfoDto.getAdvertising());
			
			pstmt.executeUpdate();
			
			
		}catch(Exception e){
			e.printStackTrace();
		
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				System.out.println("DB pstmt/connection close ");
				
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
	
		
	} // insert() END
	

	
} // Dao END
