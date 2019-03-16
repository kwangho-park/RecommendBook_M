package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostInfoDao;

public class DeletePostCommand implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int num = Integer.parseInt((request.getParameter("num")));
		
		PostInfoDao postInfoDao = new PostInfoDao();
		
		postInfoDao.deletePost(num);
		
		// recommend book page로 전달하기위한 셋팅 (게시글삭제 전달창) - 추후 삭제 전에 다이얼로그로 선택 유도
		request.setAttribute("deleteSuccess", true );
		
	}
	
}
