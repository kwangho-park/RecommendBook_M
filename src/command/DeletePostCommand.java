package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostInfoDao;
import dao.RecommendInfoDao;
import dto.PostInfoDto;
import dto.RecommendInfoDto;
import service.AverageScoreCal;

public class DeletePostCommand implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int num = Integer.parseInt((request.getParameter("num")));
		
		String bookName;
		int score;
		
		PostInfoDao postInfoDao = new PostInfoDao();
		PostInfoDto postInfoDto;
		
		RecommendInfoDao recommendInfoDao = new RecommendInfoDao();
		RecommendInfoDto recommendInfoDto;
		
		AverageScoreCal averageScoreCal = new AverageScoreCal();
		
		// 추천정보 업데이트 부//
		postInfoDto = postInfoDao.selectPost(num);
		
		bookName = postInfoDto.getBookName();
		score = postInfoDto.getScore();
		
		
		// 추천정보 업데이트 대상 조회
		recommendInfoDto = recommendInfoDao.select(bookName);
		
		
		// 추천점수 업데이트 //
		averageScoreCal.subtraction(score, recommendInfoDto);
		
		recommendInfoDao.update(recommendInfoDto);
		
		
		
		//////// 게시글 삭제부 /////////
		postInfoDao.deletePost(num);
		
		// recommend book page로 전달하기위한 셋팅 (게시글삭제 전달창) - 추후 삭제 전에 다이얼로그로 선택 유도
		request.setAttribute("deleteSuccess", true );
		
	}
	
}
