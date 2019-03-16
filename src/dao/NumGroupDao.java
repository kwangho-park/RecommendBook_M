package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NumGroupDao {
	
	private DataSource dataSource;
	
	
	// server directory context.xml의 설정된 connection pool 생성
	public NumGroupDao() {
		try {

			// ?? //
			Context context = new InitialContext();

			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
			System.out.println("connection open");

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	} // NumGroupDao() END	

	
	
	
	// 게시글 번호 조회 (numGroup table) // 
	public int selectNumGroup(String tableName) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = 0;
		try {
			
			conn = dataSource.getConnection();
			
			String query = "SELECT * FROM numGroup WHERE tableName = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tableName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("num");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(pstmt != null) pstmt.close();
				System.out.println("connection close (numGroup table)");

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	} // selectNumGroup() END
	
	
	// 게시글 번호 업데이트 (numGroup table) // 
	public void updateNumGroup(String tableName) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {	
			conn = dataSource.getConnection();
			
			String query = "UPDATE numGroup SET num = num + 1 WHERE tableName = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tableName);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(pstmt != null) conn.close();
				System.out.println("connection close (numGroup table)");

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	} // updateNumGroup() END
	
}//NumGroup END
