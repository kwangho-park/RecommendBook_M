package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostInfoDao;
import dao.RecommendInfoDao;
import dto.PostInfoDto;
import dto.RecommendInfoDto;
import service.AverageScoreCal;

public class SavePostCommand implements Command{
 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 사용자가 입력한 게시글 정보를 반환
		String bookName = request.getParameter("bookName");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String bookType = request.getParameter("bookType");
		String favorite = request.getParameter("favorite");
		String bookLevel = request.getParameter("bookLevel");
		int score = Integer.parseInt(request.getParameter("score"));
	
		// 게시글 정보 제어 //
		PostInfoDto postInfoDto = new PostInfoDto(bookName, writer, title, content, bookType, favorite, bookLevel, score);
		PostInfoDao postInfoDao = new PostInfoDao();

		// 추천 정보 제어 //
		RecommendInfoDao recommendInfoDao = new RecommendInfoDao();
		RecommendInfoDto recommendInfoDto;
		
		
		AverageScoreCal averageScoreCal = new AverageScoreCal();
		
		
		
		// 추천 정보 조회 //
		recommendInfoDto = recommendInfoDao.select(bookName);
		
		
		// 추천정보 업데이트 or 삽입
		if(recommendInfoDto != null) {			
			
			
			// [service]
			averageScoreCal.addition(score, recommendInfoDto);
			
			// [DAO]
			recommendInfoDao.update(recommendInfoDto);
			
		}else { 

			recommendInfoDao.insert(postInfoDto);
		}
		
		
		

		// 게시글 정보를 저장 // 
		postInfoDao.insertPost(postInfoDto);
		
		// browser 경고창 출력을 위한 setting
		request.setAttribute("saveSuccess", true);

	}
	
} // SavePostCommand END
