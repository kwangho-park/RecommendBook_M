package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.PostInfoDto;
import dto.SearchPostInfoDto;

// recommendBook page에서 추천도서 검색 시 실행
// search post class // 
public class SearchPostInfoDao {

	private DataSource dataSource;
	
	public SearchPostInfoDao() {
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
			
			System.out.println("conncetion open");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}// PostInfoSearchDao() END
	
	
/*	
	// client에서 요청한 조건으로 검색하는 로직 // 
	// 분류, 취향, 난이도
	public ArrayList<PostInfoDto> SearchPost(String bookType, String favorite, String bookLevel) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<PostInfoDto> listDto = new ArrayList<PostInfoDto>();
		
		try {
			
			conn = dataSource.getConnection();
			
			String query = "SELECT bookName, writer, score FROM postInfo "
					+ "WHERE bookType=? && favorite=? && bookLevel=? "
					+ "ORDER BY score DESC LIMIT 0,5";
			
			pstmt = conn.prepareStatement(query);

			
			pstmt.setString(1, bookType);
			pstmt.setString(2, favorite);
			pstmt.setString(3, bookLevel);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {								// 조건문 실행되지않음
				
				String bookName = rs.getString("bookName");
				String writer = rs.getString("writer");
				int score = rs.getInt("score");
				
				PostInfoDto dto = new PostInfoDto();
				
				dto.setBookName(bookName);
				dto.setWriter(writer);
				dto.setScore(score);
				
				listDto.add(dto);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				System.out.println("connection close (postInfo table)");

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return listDto;
		
	}// SearchPost() END
	
*/
	
	
	// client에서 요청한 조건으로 검색하는 로직 // 
	// 분류, 취향, 난이도
	public ArrayList<SearchPostInfoDto> SearchPost(String bookType, String favorite, String bookLevel) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<SearchPostInfoDto> listDto = new ArrayList<SearchPostInfoDto>();
		
		try {
			
			conn = dataSource.getConnection();
			
			String query = 
			
					" SELECT DISTINCT postInfo.bookName, postInfo.writer, recommendInfo.averageScore "

					+ " FROM recommendInfo INNER JOIN postInfo " 
				    
				    + " ON postInfo.bookName = recommendInfo.bookName "

					+ " WHERE bookType=? && favorite=? && bookLevel=? "
					
					+ " ORDER BY averageScore DESC LIMIT 0,5 " ;

					
			pstmt = conn.prepareStatement(query);

			
			pstmt.setString(1, bookType);
			pstmt.setString(2, favorite);
			pstmt.setString(3, bookLevel);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {								// 조건문 실행되지않음
				
				String bookName = rs.getString("bookName");
				String writer = rs.getString("writer");
				int averageScore = rs.getInt("averageScore");
				
				SearchPostInfoDto dto = new SearchPostInfoDto();
				
				dto.setBookName(bookName);
				dto.setWriter(writer);
				dto.setAverageScore(averageScore);
				
				listDto.add(dto);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				System.out.println("connection close (postInfo table)");

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return listDto;
		
	}// SearchPost() END
	
	
	
}// SearchPostInfoDao END
