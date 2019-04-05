package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostInfoDao;
import dto.PostInfoDto;

public class ViewPostCommand implements Command{
	 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		
		PostInfoDao postInfoDao = new PostInfoDao();
		
		
		PostInfoDto postInfoDto = postInfoDao.selectPost(num);
		
		// request에 게시글을 정보를 저장하고있는 DTO 셋팅
		request.setAttribute("dto", postInfoDto);
	}
}// PostViewCommand END
