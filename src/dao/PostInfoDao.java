package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.PostInfoDto;


// DB postInfo table 에 접근하기 위한 method //
public class PostInfoDao {

	
	private DataSource dataSource;
	private NumGroupDao numGroupDao;
	
	// server directory context.xml의 설정된 connection pool 생성
	public PostInfoDao() {
		try {

			// ?? //
			Context context = new InitialContext();

			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
			System.out.println("connection open");

			numGroupDao = new NumGroupDao();			// DI객체 (Dependency Injection)
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	} // PostInfo() END	

	
	
	
	// 게시글 data 를 db에 저장 // 
	public void insertPost(PostInfoDto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num = 0;
		
		try {
			
			// 게시글 번호를 조회하는 로직 추가 
			num = numGroupDao.selectNumGroup("postInfo");
			
			conn = dataSource.getConnection();

			String query = "INSERT INTO postInfo VALUES(?,?,?,?,?,?,?,?,?)";		// sql문 검증완료
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);			
			pstmt.setString(2, dto.getBookName());		
			pstmt.setString(3, dto.getWriter());
			pstmt.setString(4, dto.getTitle());
			pstmt.setString(5, dto.getContent());
			pstmt.setString(6, dto.getBookType());
			pstmt.setString(7, dto.getFavorite());
			pstmt.setString(8, dto.getBookLevel());
			pstmt.setString(9, dto.getScore());

		
			pstmt.executeUpdate();		
			
			numGroupDao.updateNumGroup("postInfo");
			
			
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
	} // inset() END
	
	
	// 게시글 리스트를 조회 //
	public ArrayList<PostInfoDto> selectAllPost() {
		
		ArrayList<PostInfoDto> listDto = new ArrayList<PostInfoDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			
			conn = dataSource.getConnection();
			
			String query = "SELECT * FROM postInfo ORDER BY num ASC";
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num 		= rs.getInt("num");
				String bookName = rs.getString("bookName");
				String writer 	= rs.getString("writer");
				String title 	= rs.getString("title");
				String content 	= rs.getString("content");
				String bookType = rs.getString("bookType");
				String favorite = rs.getString("favorite");
				String bookLevel= rs.getString("bookLevel");
				String score 	= rs.getString("score");
				
				PostInfoDto dto = new PostInfoDto(num, bookName, writer, title, content, bookType, favorite, bookLevel, score);
				
				listDto.add(dto);	
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return listDto;
		
	} // selectAllPost() END
	
	
	
	// 특정 게시글(num)을 조회 //
	public PostInfoDto selectPost(int num) {
		
		PostInfoDto postInfoDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			
			String query = "SELECT * FROM postInfo WHERE num = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String bookName = rs.getString("bookName");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String bookType = rs.getString("bookType");
				String favorite = rs.getString("favorite");
				String bookLevel = rs.getString("bookLevel");
				String score = rs.getString("score");
				
				postInfoDto = new PostInfoDto(num, bookName, writer, title, content, bookType, favorite, bookLevel,score);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally{
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		

		return postInfoDto;
		
	} // selectPost() END
	
	
	
	
	// 특정게시글(num)을 삭제 //
	public void deletePost(int num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			
			String query="DELETE FROM postInfo WHERE num=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
								
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}// deletePost() END
	
	
	
	// 특정(num)게시글을 수정 //
	public void updatePost(int num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			

			
			/// 게시글을 수정하는 SQL 실행
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
								
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	} // updatePost() END
	
} // PostInfoDao END
