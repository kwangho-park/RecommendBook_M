package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostInfoDao;
import dto.PostInfoDto;

public class SelectPostCommand implements Command{
  
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		PostInfoDao postInfoDao = new PostInfoDao();
		
		ArrayList<PostInfoDto> listDto = postInfoDao.selectAllPost();
	
	
		// recommend book page 로 전달하기위한 셋팅
		request.setAttribute("listDto", listDto);
		
		
	} // execute() END
	
}// SelectPostCommand END
