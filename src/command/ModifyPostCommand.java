package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostInfoDao;
import dao.RecommendInfoDao;
import dto.PostInfoDto;
import dto.RecommendInfoDto;
import service.AverageScoreCal;

public class ModifyPostCommand implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		/// 게시글 정보를 전달받음
		
		int num = Integer.parseInt(request.getParameter("num"));
		String bookName = request.getParameter("bookName");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String bookType = request.getParameter("bookType");
		String favorite = request.getParameter("favorite");
		String bookLevel = request.getParameter("bookLevel");
		int score = Integer.parseInt(request.getParameter("score"));
			
		// 게시글 정보 제어 //
		PostInfoDto postInfoDto = new PostInfoDto(num, bookName, writer, title, content, bookType, favorite, bookLevel, score);
		PostInfoDao postInfoDao = new PostInfoDao();
		
		// 추천 정보 제어//
		RecommendInfoDao recommendInfoDao = new RecommendInfoDao();
		RecommendInfoDto recommendInfoDto;
		RecommendInfoDto recommendInfoDto2;
		
		AverageScoreCal averageScoreCal = new AverageScoreCal();

		
		
		// 게시글 수정 전 data setting // 
		PostInfoDto postInfoDto2 = postInfoDao.selectPost(num);
		
		String beforeBookName = postInfoDto2.getBookName(); 
		int beforeScore = postInfoDto2.getScore();

		
		
		// 추천 정보 조회
		recommendInfoDto = recommendInfoDao.select(bookName);			// 수정 예정 추천정보
		recommendInfoDto2 = recommendInfoDao.select(beforeBookName);	// 수정 전 추천정보
		
				
		// 도서명 변경 시
		if(!beforeBookName.equals(bookName)) {		
			
			
			// 추천정보 업데이트 or 삽입 
			if(recommendInfoDto != null) {			
				
				// [service]
				averageScoreCal.addition(score, recommendInfoDto);
				
				// [DAO]
				recommendInfoDao.update(recommendInfoDto);
				
			}else { 

				recommendInfoDao.insert(postInfoDto);
			}
		
			
			// 수정 전 도서의 추천점수를 업데이트 //
			// [service]
			averageScoreCal.subtraction(beforeScore, recommendInfoDto2);
			
			// [DAO]
			recommendInfoDao.update(recommendInfoDto2);
			
			
			
		// 도서명 동일 + 추천점수 변경
		}else if((beforeBookName.equals(bookName)) && (beforeScore != score)) {	

			// [service] 
			averageScoreCal.modify(score, beforeScore, recommendInfoDto);
			
			// [dao]
			recommendInfoDao.update(recommendInfoDto);
		}
		
		
		

		
		// 게시글 수정 DAO
		postInfoDao.updatePost(postInfoDto);

		
		// 수정완료 경고창 출력용 셋팅
		request.setAttribute("modifySuccess", true);
		
	}

}// ModifyPostCommand END
