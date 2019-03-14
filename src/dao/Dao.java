package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.UserInfoDto;

public class Dao {

	
	
	DataSource dataSource;
	
	// server directory context.xml의 설정된 connection pool 생성
	public Dao() {
		try {

			// ?? //
			Context context = new InitialContext();
			
			// debugging
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
				
/*			
 			//java 단에서 실행시 connection pool 설정 파일인 server.xml에 접근하지못함???;; (추정)
 			// 아래로 변환해서 테스트를 해야하나??
 			
			String driverName = "com.mysql.cj.jdbc.Driver";		// JDBC Driver
			Class.forName(driverName);
			
			String url = "jdbc:mysql://localhost:3306/noticeboardtest ? useSSL=false & characterEncoding=UTF-8 & serverTimezone=UTC" ;	

			con = DriverManager.getConnection(url,"root","peterrabbit");			// 계정 URL, id, pw

*/
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	} // Dao() END
	
	
	// user table에 data를 입력하는 method
	public void insertUserInfo(UserInfoDto userInfoDto) {
		
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
		
	} //insertUserInfo() END
	
	
	
	
} // Dao END
