package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostInfoDao;
import dto.PostInfoDto;
import service.PostPaging;

public class SelectPostCommand implements Command{
  
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		PostInfoDao postInfoDao = new PostInfoDao();
		
		PostPaging postPaging = new PostPaging();
		
		
		ArrayList<PostInfoDto> listDto = postInfoDao.selectAllPost();
	
		
		int totalCount = postInfoDao.selectTotalCount();
		
		int[] countPage = postPaging.countPage(totalCount);
		
	
		// recommend book page 로 전달하기위한 셋팅
		request.setAttribute("listDto", listDto);
		request.setAttribute("countPage", countPage);
		
	} // execute() END
	
}// SelectPostCommand END
