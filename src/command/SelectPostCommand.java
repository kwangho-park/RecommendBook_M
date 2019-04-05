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
	 
		int[] searchInfo = new int[2];	


		// DB에서 post를 검색하기 위한 property//
		
		int totalCount = 0;
		
		int pageNum = 0;
		
		String initPageNum = "";
		
		
		// DB에서 post를 검색 //
		
		totalCount= postInfoDao.selectTotalCount();
		
		initPageNum = request.getParameter("pageNum");

		
		if(initPageNum == null) {		// 초기 recommendBook page 로드 시 parameter가 없는것을 보완
			pageNum = 1;
			
		}else {
			pageNum = Integer.parseInt(initPageNum);			
		}
	
		
		// page에 출력 할 post setting // 
		searchInfo = postPaging.searchPost(pageNum, totalCount);

		ArrayList<PostInfoDto> listDto = postInfoDao.selectPage(searchInfo);		
		
		request.setAttribute("listDto", listDto);
		
		
		
		
		// countPage 출력부 //
		int[] countPage = postPaging.countPage(totalCount);
		
		request.setAttribute("countPage", countPage);
		
		
		
		
		
	} // execute() END
	
}// SelectPostCommand END
