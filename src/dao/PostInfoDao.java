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

	// server directory context.xml의 설정된 connection pool 생성
	public PostInfoDao() {
		try {

			// ?? //
			Context context = new InitialContext();

			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
			System.out.println("connection open");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	} // PostInfo() END	

	
	
	
	// 게시글 data 를 db에 저장 // 
	public void insertPost(PostInfoDto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		try {
			

			conn = dataSource.getConnection();

			String query = "INSERT INTO postInfo(bookName, writer, title, content, "
					+ "bookType, favorite, bookLevel, score) VALUES(?,?,?,?,?,?,?,?)";		// sql문 검증완료
			pstmt = conn.prepareStatement(query);

			// 게시글 번호 num 은 AUTO_INCREMENT 적용
			pstmt.setString(1, dto.getBookName());		
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getBookType());
			pstmt.setString(6, dto.getFavorite());
			pstmt.setString(7, dto.getBookLevel());
			pstmt.setInt(8, dto.getScore());

		
			pstmt.executeUpdate();		

			
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
	} // insertPost() END
	
	
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
				int score 	= rs.getInt("score");
				
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
				int score = rs.getInt("score");
				
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
	public void updatePost(PostInfoDto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			
			String query = "UPDATE postInfo SET bookName=?, writer=?, title=?, "
					+ "content=?, bookType=?, favorite=?, bookLevel=?, score=?"
					+ "WHERE num = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getBookName());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getBookType());
			pstmt.setString(6, dto.getFavorite());
			pstmt.setString(7, dto.getBookLevel());
			pstmt.setInt(8, dto.getScore());
			pstmt.setInt(9, dto.getNum());
			
			
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
	} // updatePost() END
	
	
	
	
	
	// 전체 게시글의 수를 조회 (row의 총 갯수)
	public int selectTotalCount() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = 0;
		
		try {
			conn = dataSource.getConnection();

			String query ="SELECT count(*) as totalCount FROM postInfo";
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("totalCount");
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
		
		
		return result;
		
	}// selectTotalCount() END
	
	
	
	
	
	// test
	////// 변경예정
	public ArrayList<PostInfoDto> selectFirstPage(int[] searchInfo) {
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		PostInfoDto postInfoDto = null;
		ArrayList<PostInfoDto> listDto = new ArrayList<PostInfoDto>();
		
		try {
			
			conn = dataSource.getConnection();
			
			
			///// 변경예정
			// searchInfo를 적용하여 pageNum에 해당하는 게시글 조회: startNum, countList 값
			String query = "SELECT * FROM postInfo ORDER BY num DESC LIMIT 0,10";
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {

				int num = rs.getInt("num");
				String bookName = rs.getString("bookName");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String bookType = rs.getString("bookType");
				String favorite = rs.getString("favorite");
				String bookLevel = rs.getString("bookLevel");
				int score = rs.getInt("score");
				
				postInfoDto = new PostInfoDto(num, bookName, writer, title, content, bookType, favorite, bookLevel,score);
				
				listDto.add(postInfoDto);
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
		
	}//selectFirstPage() END
	
} // PostInfoDao END
