package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostInfoDao;
import dto.PostInfoDto;

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
		String score = request.getParameter("score");
		
		PostInfoDto postInfoDto = new PostInfoDto(num, bookName, writer, title, content, bookType, favorite, bookLevel, score);
		
		PostInfoDao postInfoDao = new PostInfoDao();
		
		// 게시글 수정 DAO
		postInfoDao.updatePost(postInfoDto);

		
		// 수정완료 경고창 출력용 셋팅
		
		request.setAttribute("modifySuccess", true);
		
	}

}// ModifyPostCommand END
