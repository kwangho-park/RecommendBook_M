package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostInfoDao;
import dto.PostInfoDto;

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
		String score = request.getParameter("score");
		
		PostInfoDto postInfoDto = new PostInfoDto(bookName, writer, title, content, bookType, favorite, bookLevel, score);
		PostInfoDao postInfoDao = new PostInfoDao();
		
		
		// 게시글 정보를 DB에 저장
		postInfoDao.insertPost(postInfoDto);
		
		// browser 경고창 출력을 위한 setting
		request.setAttribute("saveSuccess", true);

	}
	
} // SavePostCommand END
