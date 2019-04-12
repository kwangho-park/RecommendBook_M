package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.PostInfoDto;
import dto.RecommendInfoDto;

public class RecommendInfoDao {

	private DataSource dataSource;

	// server directory context.xml의 설정된 connection pool 생성
	public RecommendInfoDao() {
		try {

			// ?? //
			Context context = new InitialContext();

			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
			System.out.println("connection open");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	} // RecommendInfoDao() END	
	
	
	
	// recommendInfo table에서 도서명 조회 //
	public RecommendInfoDto select(String bookName) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RecommendInfoDto recommendInfoDto = new RecommendInfoDto();
		
		
		try {
			
			conn = dataSource.getConnection();
			
			String query = "SELECT * FROM recommendInfo WHERE bookName = ?";	
			pstmt = conn.prepareStatement(query);			
			pstmt.setString(1, bookName);

			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {

				int averageScore = rs.getInt("averageScore");
				int counter = rs.getInt("counter");
				
				recommendInfoDto.setAverageScore(averageScore);
				recommendInfoDto.setCounter(counter);
				recommendInfoDto.setBookName(bookName);	
				
			}else {
				recommendInfoDto = null;
			}

			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				System.out.println("connection close");

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return recommendInfoDto;
		
	} // select() END
	
	
	// 최초 도서 등록 시
	// recommendInfo table에 도서정보를 등록
	public void insert(PostInfoDto postInfoDto) {
		
		// user가 입력한 정보
		String bookName = postInfoDto.getBookName(); 
		int score = postInfoDto.getScore();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = dataSource.getConnection();
			
			String query = "INSERT INTO recommendInfo(bookName, averageScore, counter) VALUES(?,?,1)";	
			pstmt = conn.prepareStatement(query);			
			pstmt.setString(1,bookName);
			pstmt.setInt(2,score);

			pstmt.executeUpdate();

			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				System.out.println("connection close");

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	} // insert() END
	
	

	
	public void update(RecommendInfoDto recommendInfoDto) {
		
		// RecommendInfo에서 조회하여 가공한 정보
		String bookName = recommendInfoDto.getBookName();
		int averageScore = recommendInfoDto.getAverageScore();
		int counter = recommendInfoDto.getCounter();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
	
		try {
			
			conn = dataSource.getConnection();
			
			String query = "UPDATE recommendInfo SET averageScore=?, counter=? WHERE bookName=?";
			pstmt = conn.prepareStatement(query);			
			pstmt.setInt(1,averageScore);
			pstmt.setInt(2, counter);
			pstmt.setString(3,bookName);

			
			pstmt.executeUpdate();

			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				System.out.println("connection close");

			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	} // update() END
	
	
	
}// RecommendInfoDao END
